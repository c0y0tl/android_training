# Android основы

## @Composable
Составные (Composable) функции - основные блоки пользовательского интерфейса
* Описывают некоторую часть интерфейса
* Ничего не возвращают
* Принимают в себя входные данные и на их основе генерируют контент

```kt
@Composable // Аннотация
fun Greeting(name: String, modifier: Modifier) {
    Text(
        text = "Привет! $name"
    )
}
```

## @Preview
```kt
@Preview (
    name = "Preview name", // Название
    showBackground = true, // Показывать фон
    showSystemUi = true // Отображение стандартного UI
)
@Composable // Аннотация
fun GreetingPreview() {
    Greeting("Привет!")
}
```

## Расположение элементов
Основные составные функции для элементов  
`Row` - строка  
`Column` - столбец  
`Box` - блок  

```kt
fun Greeting(name: String, modifier: Modifier) {
    Row {
        Text(
            text = "Привет!"
        )
        Text(
            text = "$name"
        )
    }
}
```

Если выделить элементы, нажать `Alt + Enter` > `Surround with widget` можно автоматически их обернуть.

Свойства составных элементов записываются в скобках
```kt
Row (
    verticalArrangement = Arrangement.Center,
    modifier  = modifier.padding(8pd)
)
```

## Modifier
Модификаторы используются для украшения элементов и записываются следующим образом
```kt
modifier = Modifier
    .clickable(onClick = onClick)
    .padding(8.dp)
    .fillMaxWidth()
```

### Разница между `modifier = modifier.` и `modifier = Modifier.`
> Вполне возможно, что это объяснение не корректное.   

Если в функции мы определяем `modifier = modifier.`, то мы можем добавлять новые свойства при вызове функции. Если определено `modifier = Modifier.` то свойства не работают (игнорируются).

### modifier: Modifier = Modifier - Параметр функции
`название`: `Тип` = `стандартное свойство`  
Такой вариант используется, если `modifier` это не обязательный параметр, который можно опустить.

### Modifier.weight(1f)
Используется для дочернего элемента. Область делится в соответствии с пропорциями, которые заданы в скобках.

Пример
```kt
    Column(Modifier.fillMaxWidth()) {
        Row(Modifier.weight(1f)) {
            CreateContent(
                "Title 1", 
                "Desc 1", 
                modifier = Modifier.weight(1f)
            )
            CreateContent(
                "Title 2", 
                "Desc 2", 
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            CreateContent(
                "Title 3", 
                "Desc 3", 
                modifier = Modifier.weight(1f)
            )
            CreateContent(
                "Title 4", 
                "Desc 4", 
                modifier = Modifier.weight(1f)
            )
        }
    }
```
`Colum (Родитель) > Row (Дочка)` -> Следовательно `Row` делят высоту 1:1

`Row (Родитель) > CreateContent() (Дочка)` -> следовательно содержимое композ функции `CreateContent()` делит ширину 1:1

## Ресурсы

### Изображения
Изображения хранятся в ресурсах, для доступа к изображению используется
```kt
repainterResource(id = R.drawable.img_id)
```

### Строки
Строки хранятся в ресурсах, для доступа к строки используется 
```kt
stringResource(R.string.string_id)
```