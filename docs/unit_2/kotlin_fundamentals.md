# Unit 2
## Условия
### if
Если `condition = true` выполнить `body 1` иначе `body 2`. `else` опциональный.
```kt
if (condition) {
    body 1
} else {
    body 2
}
```

### Операторы сравнения
* Меньше чем `<`
* Больше чем `>`
* Меньше или равно `<=`
* Больше или равно `>=`
* Не равно `!=`

### Множество условий else if
Несколько условий. Если `condition 1 = true` выполнить `body 1`, если `condition 2 = true` выполнить `body 2` иначе `body 3`. Последний `else` опциональный.

```kt
if (condition 1) {
    body 1
} else if (condition 2) {
    body 2
} else {
    body 3
}
```

### Условие when
Для большого количества условий можно использовать `when`. Рекомендуема замена `if` если больше двух веток с условиями.
```kt
when (parameter) {
    condition 1 -> body 1
    condition 2 -> body 2
    condition 3 -> {
        body 3;
    }
    condition 4, condition 4.2 -> body 4
    condition 5 -> body 5
    is Int -> body 6
    else -> ...
}
```

Для условий также можно использовать диапазон, используя `in c1..c2` (Включая границы). `c1` и `c2` - границы диапазона.

Для проверки типа используется `is Type`

`when` принимает `parameter` и последовательно сравнивает его с каждым `condition`. Выполняется тело первого истинного условия. `else` опциональный.

### when без аргумента
Такая запись может использоваться в качестве замены if-else
```kt
when {
    x.isOdd() -> print("x is odd")
    y.isEven() -> print("y is even")
    else -> print("x+y is odd")
}
```

### Выражения if-else и when
При использование данной записи `else` является обязательным. Тело должно содержать переменную или выражение.
```kt
var a = if (true) {10} else {20}
// -> a = 10
```
Аналогично и для `when`.
```kt
fun main() {
    val n = 1

    val message = when(n) {
        1 -> "One"
        0 -> "Zero"
        else -> "ㄟ( ▔, ▔ )ㄏ"
    }
}
// -> One
```
## null
Для переменной можно указать значение `null`, чтобы указать, что она не содержит значения.

### Допущение null значения
Чтобы допустить использования `null` при объявление переменной после типа следует поставить `?`  
```kt
var name: type? = value
```

### Оператор ?
Для доступа к методу или свойству переменных не допускающих null используется оператор `?`
```kt
var myVar: String? = "Hello"
println(myVar?.length)
//-> 5
```
Без использования оператора возникнет ошибка.

### Оператор !!
`!!` оператор не null для переменных допускающих null значение.

`!!` использование оператора подтверждает, что переменная не является null-ом. Если переменная окажется равна `null` возникнет ошибка `NullPointerException`.

### Проверка на null
Можно проверить переменную на `null` с помощью условия `if`
```kt
if (myVar != null) {
    body 1 (no null)
} else {
    body 2 (null)
}
```
Также можно использовать и этот вариант, чтобы преобразовать допускающую `null` переменную в не допускающую `null` переменную
```kt
var favorite: Int? = 14

val favoriteNotNull = if (favorite != null) {
  favorite
} else {
  0
}
```
### Оператор Элвис ?:
С помощью этого оператора мы можем добавить после `?.` стандартное значение, если переменная окажется `null`
```kt
favorite?.length ?: 0
```

## Классы и объекты

### Определение класса
```kt
class name {
    body
}
```

Класс состоит их трёх частей
* **Свойства** - переменные, которые задают атрибуты объектов класса.
* **Методы** - функции, которые определяют поведение класса.
* **Конструкторы** - создает экземпляр класса.

### Создание экземпляра класса
Для создания экземпляра класса используется следующая конструкция
```kt
ClassName()
```
Чтобы воспользоваться объектом, мы создаем объект и присваиваем его переменной
```kt
val/var name = ClassName()
```
`val` - только для чтения

### Определение методов класса
Определение функции в классе аналогичен обычному, только функции находятся внутри класса.

### Вызов метода для объекта
Чтобы вызвать метод используется оператор `.`

```kt
ClassName.methodName([Optional parameters])
```

### Определение свойств класса

Свойства класса - это переменные, которые определены в теле класса (не внутри функции). Свойства класса можно получить используя оператор `.`
```kt
class ClassName {
    var varName = "Hello"
}

fun main() {
    val classInstance = ClassName()
    println(classInstance.varName)
}
```

### set() get() функции
```kt
var name: dataType = initialValue
    get() {
        body
        return statement
    }
    set(value) {
        body
    }
```
`val` не имеет `set()`

Пример
```kt
var volume = 2
    get() = field  
    set(value) {
        field = value    
    }
```

Имя свойства нельзя использовать для получения или установки значения. Это приведет к бесконечному циклу. 

### Конструкторы
Конструкторы инициализируют объекты и подготавливают их к использованию.

Конструктор по умолчанию
```kt
class ClassName constructor() {
    ...
}
```
Краткий вид, если нет аннотации и модификаторов доступа. Если отсутствуют параметры
```kt
class ClassName {
    ...
}
```
### Параметризованные конструкторы
```kt
class ClassName(val name: String, val surname: String) {
    ...
}
```
В таком случае меняется и создание экземпляра класса
```kt
ClassName("Sergei", "Korablev")
```
Можно создать конструктор с именованными аргументами
```kt
ClassName(name = "Sergei", surname = "Korablev")
```
### Типы конструкторов
**Основной** - класс может иметь только один основной конструктор, который определяется как часть заголовка класса. Он может быть конструктором по умолчанию или параметризованным конструктором. Не имеет тела (Не содержит кода)

```kt
class ClassName constructor(parameters) {
    body
}
```


**Дополнительный** - класс может иметь несколько дополнительных конструкторов. Конструкторы могут быть определены с параметрами или без них. Он может инициализировать класс и имеет тело. Если класс имеет основной конструктор то каждый дополнительный конструктор должен инициализировать основной конструктор.

```kt
class ClassName constructor(primaryConstructorParameters) {
    constructor(parameters) : this(primaryConstructorParameters) {
        body
    }
}
```

### Взаимодействие между классами
Родительский класс - суперкласс. Дочерний класс - подкласс.  

По умолчанию все классы в Kotlin `final`. Чтобы сделать его расширяемым следует добавить `open` перед ключевым словом `class`. `open` сообщает, что другие классы теперь могут расширить его.
```kt
open class SmartDevice(val name: String, val category: String) {
    ...
}
```

Синтаксис создания подкласса
```kt
class SubClassName ([optional] parameters) : SuperClassName ([optional] parameters) {
    body
}
```
Пример
```kt
class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {
}
```
В конструкторе `SmartTvDevice` не указано являются ли свойства изменяемыми или неизменяемыми. Поэтому `deviceName` и `deviceCategory` просто параметры конструктора, которые нельзя использовать классе и они просто передаются суперклассу.

### Связи между классами
При использование наследования мы устанавливаем отношение `IS-A`. Объект также является экземпляром класса, от которого он наследуется.

В отношение `HAS-A` объект может владеть экземпляром другого класса, фактически не являясь экземпляром самого класса.


![alt text](https://developer.android.com/static/codelabs/basic-android-kotlin-compose-classes-and-objects/img/43ebe1f550d6c614_856.png)

### IS-A
Всё, что может делать суперлкасс может делать и подкласс. Отношения при этом односторонние.

### HAS-A
Отношения HAS-A между двумя классами также называют композицией.

### Переопределение методов суперкласса из подклассов
Переопределить т.е. перехватить действие. Когда переопределяется метод, метод в подклассе, прерывает метод в суперклассе и обеспечивает собственное выполнение.

Перед переопределяемой функцией ставится ключевое слово `open`

Добавление ключевого слова `override` перед функции, сообщает среде выполнения о необходимости выполнить кода, который находится в методе класса.

Переопределение функций `turnOn()` и `turnOff()`. Пример полиморфизма. Код вызывает `turnOn()` для `smartDevice` в зависимости от значения переменной вызывать разные `turnOn()`

```kt
open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"

    open fun turnOn() {}
    open fun turnOff() {}
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Volume +$speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel $channelNumber")
    }

    override fun turnOn() {
        deviceStatus = "on"
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        deviceStatus = "off"
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness $brightnessLevel")
    }

    override fun turnOn() {
        deviceStatus = "on"
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        deviceStatus = "off"
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

// class SmartHome пример отношений HAS-A
class SmartHome(
    val smartTvDevices: SmartTvDevice,
    val smartLightDevice: SmartLightDevice
) {
    fun turnOnTv() {
        smartTvDevices.turnOn()
    }

    fun turnOffTv() {
        smartTvDevices.turnOff()
    }

    fun increaseTvVolume() {
        smartTvDevices.increaseSpeakerVolume()
    }

    fun changeTvChannelToNext() {
        smartTvDevices.nextChannel()
    }

    fun turnOnLight() {
        smartLightDevice.turnOn()
    }

    fun turnOffLight() {
        smartLightDevice.turnOff()
    }

    fun increaseLightBrightness() {
        smartLightDevice.increaseBrightness()
    }

    fun turnOffAllDevices() {
        turnOffTv()
        turnOffLight()
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}
```

### Повторное использование кода суперкласса в подклассах с ключевым словом `super`
Чтобы вызвать переопределенный метод суперкласса из подкласса используется ключевое слово `super`. Чтобы уменьшить количество повторений в коде.

```kt
supper.functionName([optional]parameters)
```

На примере предыдущего кода

```kt
open class SmartDevice(val name: String, val category: String) {
    var deviceStatus = "online"

    open fun turnOn() {
        deviceStatus = "on"
    }
    open fun turnOff() {
        deviceStatus = "off"
    }
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var speakerVolume = 2
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    var channelNumber = 1
        set(value) {
            if (value in 0..200) {
                field = value
            }
        }

    fun increaseSpeakerVolume() {
        speakerVolume++
        println("Volume +$speakerVolume")
    }

    fun nextChannel() {
        channelNumber++
        println("Channel $channelNumber")
    }

    override fun turnOn() {
        super.turnOn()
        println(
            "$name is turned on. Speaker volume is set to $speakerVolume and channel number is " +
                    "set to $channelNumber."
        )
    }

    override fun turnOff() {
        super.turnOff()
        println("$name turned off")
    }
}

class SmartLightDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    var brightnessLevel = 0
        set(value) {
            if (value in 0..100) {
                field = value
            }
        }

    fun increaseBrightness() {
        brightnessLevel++
        println("Brightness $brightnessLevel")
    }

    override fun turnOn() {
        super.turnOn()
        brightnessLevel = 2
        println("$name turned on. The brightness level is $brightnessLevel.")
    }

    override fun turnOff() {
        super.turnOff()
        brightnessLevel = 0
        println("Smart Light turned off")
    }
}

fun main() {
    var smartDevice: SmartDevice = SmartTvDevice("Android TV", "Entertainment")
    smartDevice.turnOn()

    smartDevice = SmartLightDevice("Google Light", "Utility")
    smartDevice.turnOn()
}
```

### Переопределение свойств суперкласса из подклассов
Переопределение свойств суперкласса происходит, как и переопределение методов. В суперклассе перед свойством ставится ключевое слово `open`, а в подклассе перед свойство ставится `override`

```kt
open class SmartDevice(val name: String, val category: String) {
    ...
    open val deviceType = "unknown"
    ...
}

class SmartTvDevice(deviceName: String, deviceCategory: String) :
    SmartDevice(name = deviceName, category = deviceCategory) {

    override val deviceType = "Smart TV"

    ...
}
```

### Модификаторы видимости
Модификаторы видимости позволяют
* В классе они позволяют скрыть свойства и методы от несанкционированного доступа за пределами класса
* В пакете они позволяют скрыть классы и интерфейсы от несанкционированного доступа за пределами пакета

Модификаторы видимости
* `public` - модификатор по умолчанию. Виден везде. Свойства и методы, которые используются вне класса помечены как общедоступные.
* `private` - члены класса с этим модификатором видны только в классе. Все что определено вне класса с этим модификатором видно только внутри файла.
* `protected` - члены класса видны в классе в котором они определены и подклассах. 
* `internal` - виден в модуле в котором они определены. Модуль представляет набор файлов Kotlin, скомпилированных вместе в одну структурную единицу.

Для свойств модификатор указывается перед `var` / `val`. Используются модификаторы `private`, `protected` и `internal`.

`modifier` var `name` : `data type` = `initial value`

Для функции `set` модификатор указывается перед `set()`. Модификатор функции и свойства должны совпадать. Иначе возникнет ошибка.
```kt
var name : dataType = initialValue
    modifier set (value) {
        body
    }
```
Если для `set` происходит только присваивания можно опустить круглые скобки
```kt
var deviceTurnOnCount = 0
    private set
```

Для методов модификатор указывается перед `fun`

```kt
modifier fun name() {
    body
}
```

Для конструкторов модификатор указывается перед `constructor`

Для класса модификатор указывается перед ключевым словом `class`

> В идеале вы должны стремиться к строгой видимости свойств и методов, поэтому объявляйте их с помощью `private` модификатора как можно чаще. Если вы не можете сохранить их приватными, используйте `protected` модификатор. Если вы не можете сохранить их защищенными, используйте модификатор `internal`. Если вы не можете сохранить их внутренними, используйте модификатор `public`.

| Модификатор | Доступны в том же классе | Доступно в подклассе | Доступны в том же модуле | Доступный внешний модуль
|---|---|---|---|---|
| private | x | - | - | - |
| protected | x | x | - | - |
| internal | x | x | x | - |
| public | x | x | x | x |