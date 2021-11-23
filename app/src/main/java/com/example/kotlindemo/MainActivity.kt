package com.example.kotlindemo

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity

/**
 * @author TomCan
 * @description: Kotlin语法学习
 * @date :2021/11/18 16:27
 */

class MainActivity : AppCompatActivity() {

    /**
     * 声明一个可变变量,该变量不可变，不支持重新赋值
     */
    val name: String = "王菲"
    //  通过java的三元表达式增强对kotlin语法的理解：String name = (age == 18 ? "王靖雯" : "王菲")；

    /**
     * 声明一个不可变变量，该变量可变，支持重新赋值
     */
    var age: Int = 18

    /**
     * 声明一个不可变变量，该变量不可变，不支持重新赋值
     * 编译器在编译的时候，通过类型推断，可推断出该变量的类型为String类型
     */
    val gender = "女"

    /**
     *  通过对类型后面家？，可对声明的变量赋值为 null
     */
    var school: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btClick = findViewById<Button>(R.id.bt_click)
        btClick.setOnClickListener { }


        /**
         * 条件语句语法
         */
        var professions = ""
        if (name.equals("王菲")) {
            professions = "歌手"
        }


        /**
         *  通过条件语句给变量赋值
         */
        var description: String? = null
        if (age == 18) {
            description = "王菲已经是成年了(#^.^#)"
        } else if (age < 18) {
            description = "王菲还是个孩子啊~~~"
        } else if (age > 18) {
            description = "王菲已经是亚洲天后了~~~"
        }


        /**
         *  通过赋值条件语句表达式，给变量进行赋值
         */
        val description2: String = if (age == 18) {
            "王菲已经是成年了(#^.^#)"
        } else if (age < 18) {
            "王菲还是个孩子啊~~~"
        } else if (age > 18) {
            "王菲已经是亚洲天后了~~~"
        } else {
            "王菲是我的朋友喔~"
        }


        /**
         * 通过赋值条件语句表达式，给变量赋值
         * if-else表达式 替换为 when表达式
         *
         */
        val description3 = when {
            age == 18 -> "王菲已经是成年了(#^.^#)"
            age < 18 -> "王菲还是个孩子啊~~~"
            age > 18 -> "王菲已经是亚洲天后了~~~"
            else -> "王菲是我的朋友喔~"
        }




        // 调用函数
        val description1 = getDescription()
        Log.e("tom", "王菲的身份:$description1")

        // 调用函数并传递参数
        val description4 = getDescription(age)
        Log.e("tom", "王菲的年龄:$description4")


        // 调用匿名函数，调用方式和命名函数一样，传递String类型参数，并接收Int类型
        val nameL = nameLength("王靖雯")
        Log.e("tom", "王菲name的长度:$nameL")


        // 调用高级函数，作为参数的函数，必须用花括号括起来
//        val description41 = getDescription4(age, {getDescription3(age)})

        // 如果匿名函数是在某个函数上定义的最后一个参数，则您可以在用于调用该函数的圆括号之外传递它，如以下示例所示
        val description41 = getDescription4(age) { getDescription3(age) }
        Log.e("tom", "王菲的身份:$description41")


        val personName = getPersonName()
        Log.e("tom", "personName:$personName")


        val personName2 = getPerson2Name()
        Log.e("tom", "personName2:$personName2")


        val flContainer = findViewById<FrameLayout>(R.id.fl_container)
        val myFragment = MyFragment()
        supportFragmentManager.beginTransaction().add(R.id.fl_container, myFragment).commit()

    }


    /**
     *  函数表达式
     *  返回值类型为String
     *  给变量description赋值并返回
     */
    fun getDescription(): String {
        val description: String = if (age == 18) {
            "王菲已经是成年了(#^.^#)"
        } else if (age < 18) {
            "王菲还是个孩子啊~~~"
        } else if (age > 18) {
            "王菲已经是亚洲天后了~~~"
        } else {
            "王菲是我的朋友喔~"
        }
        return description;
    }


    /**
     * 函数表达式
     *  返回值类型为String
     *  给变量description赋值并返回
     */
    fun getDescription(age: Int): String {
        val description = if (age == 18) {
            "王菲已经是成年了(#^.^#)"
        } else if (age < 18) {
            "王菲还是个孩子啊~~~"
        } else if (age > 18) {
            "王菲已经是亚洲天后了~~~"
        } else {
            "王菲是我的朋友喔~"
        }
        return description
    }


    /**
     *  简化函数表达式
     *   直接返回条件语句
     */
    fun getDescription2(age: Int): String {
        return if (age == 18) {
            "王菲已经是成年了(#^.^#)"
        } else if (age < 18) {
            "王菲还是个孩子啊~~~"
        } else if (age > 18) {
            "王菲已经是亚洲天后了~~~"
        } else {
            "王菲是我的朋友喔~"
        }
    }


    /**
     *  简化函数表达式
     *  直接对声明的函数表达式进行赋值
     */
    fun getDescription3(age: Int): String = if (age == 18) {
        "王菲已经是成年了(#^.^#)"
    } else if (age < 18) {
        "王菲还是个孩子啊~~~"
    } else if (age > 18) {
        "王菲已经是亚洲天后了~~~"
    } else {
        "王菲是我的朋友喔~"
    }


    /**
     *  变量语法格式 与 函数语法格式 比较
     */
    val myName: String = "王靖雯"
    fun getNameLength(name: String): Int = name.length


    /**
     *  匿名函数
     *  变量 nameLength 引用了一个匿名函数，该匿名函数参数为String类型 返回值为Int类型
     *  该变量（语法）并不会调用该匿名函数，必须像命名函数一样，传递String类型，并接收Int类型，对其进行调用。
     */
    val nameLength: (String) -> Int = { name -> name.length }


    /**
     *  高级函数
     *  把函数作为一个参数，传递给另一个函数
     *  作为参数的函数，相当于声明了一个模型(规则)，该模型（规则）需要传递进来一个Int类型，并返回(接收)一个String类型
     */
    fun getDescription4(age: Int, parameter: ((Int) -> String)): String {
        return parameter(age)
    }


    /**
     *  类
     */
    class Person() {
        val name: String = "王靖雯" // public val 可在外部调用该变量
        private val age: Int = 24 // private val 可在外部调用该变量
    }


    /**
     *  类
     */
    class Person2(val name2: String) {
        val name = "王靖雯" // public val 可在外部调用该变量
        private val age = 24 // private val 可在外部调用该变量
    }

    /**
     * 声明Person类对象
     *  相当于java语法里，通过new创建一个类对象Person person = new Person();
     */
    val person = Person()


    /**
     *  通过声明类对象，调用Person类内部属性
     */
    fun getPersonName(): String = person.name


    /**
     * 该函数通过对Person2实例传递参数，并通过Person2实例访问其内部属性
     * 相当于java语法里面的通过构造传递参数
     */
    val person2 = Person2("王菲")


    /**
     *  通过声明类对象，调用Person2类内部属性
     */
    fun getPerson2Name(): String = person2.name2


    class person3 {

        val name = "王菲"
        var age = 21
            private set


        /**
         *  空构造函数
         *  相当于java语法里面的构造方法
         */
        constructor()

        /**
         * 传递参数的构造函数
         * 相当于java语法里面的构造方法
         */
        constructor(age: Int) {
            this.age = age
        }

    }


    fun getLock() {

        var person = person3(22)

    }


}