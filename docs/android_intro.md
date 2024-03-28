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
Modifier
    .clickable(onClick = onClick)
    .padding(8.dp)
    .fillMaxWidth()
```

Если мы хотим 