package main

import "fmt"

// 全局变量，并且只能用var关键词定义
// 全局变量不受是否“被用”限制
var program = "go"

func main() {
	// 先声明
	var name string
	// 再赋值
	name = "Tom"
	fmt.Println(name)

	// 声明属性并赋值
	var age int = 24
	// 直接赋值
	var gan = "man"
	fmt.Println(age, gan)

	// 声明并赋值
	yearOfNow := "2026"
	fmt.Println(yearOfNow)
}
