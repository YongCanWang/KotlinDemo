package com.example.kotlindemo

import android.accounts.Account
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import com.example.kotlindemo.fragment.HomePageFragment
import com.example.kotlindemo.fragment.MessagePageFragmnet
import com.example.kotlindemo.fragment.RecommendPageFragment
import com.example.kotlindemo.fragment.SettingPageFragment
import com.example.kotlindemo.utils.ThemeManager
import com.google.android.material.bottomnavigation.BottomNavigationView

/**
 * @author TomCan
 * @description: Kotlin语法学习
 * @date :2021/11/18 16:27
 */

class MainActivity : AppCompatActivity(), ThemeManager.OnThemeChangedListener {

    private val TAG = "MainActivity"

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
     *  通过对类型后面加？，可对声明的变量赋值为 null
     */
    var school: String? = null

    lateinit var bottomNavigation: BottomNavigationView


    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(
            if (MyApplication.isDayNight) {
                R.style.AppTheme_Custom
            } else {
                R.style.AppTheme_NoActionBar
            }
        )
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ThemeManager.getInstance().registerOnThemeChangedListener(this)
        val btClick = findViewById<Button>(R.id.bt_click)
        /**
         * SAM转换
         * SAM 转换可使代码明显变得更简洁
         * 给按钮button设置了一个点击监听
         * 当用户点击 button 时，系统会执行传递给 setOnClickListener() 的匿名函数中的代码
         */
        btClick.setOnClickListener { }
        findViewById<Switch>(R.id.sw_daynight).setOnCheckedChangeListener { compoundButton, b ->
            if (MyApplication.isDayNight == b) return@setOnCheckedChangeListener
            MyApplication.isDayNight = b
            recreate()
        }


        supportFragmentManager.beginTransaction()
            .replace(R.id.fl_container, HomePageFragment()).commit()

        bottomNavigation = findViewById(R.id.bottom_navigation)
        bottomNavigation.setOnNavigationItemReselectedListener {
            Log.e(TAG, "".plus(it.groupId).plus("---").plus(it.itemId))
            Toast.makeText(
                this,
                "".plus(it.groupId).plus("---").plus(it.itemId),
                Toast.LENGTH_SHORT
            )
        }
        bottomNavigation.setOnNavigationItemSelectedListener {

            Toast.makeText(
                this,
                it.title,
                Toast.LENGTH_SHORT
            )

            when (it.itemId) {
                R.id.item_home -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, HomePageFragment()).commit()
                    true
                }

                R.id.item_massage -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, MessagePageFragmnet(it.title.toString()))
                        .commit()
                    true
                }

                R.id.item_applet -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, RecommendPageFragment()).commit()
                    true
                }


                R.id.item_person -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fl_container, SettingPageFragment()).commit()
                    true
                }


                else -> true
            }
        }


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
        return description
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

    /**
     * 类的继承
     */
    class LoginFragment : Fragment() {
        /**
         *  override修饰
         * 方法重写，重写父类的onCreateView函数
         */
        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            /**
             * super
             * 调用父类函数
             */
            return super.onCreateView(inflater, container, savedInstanceState)
        }
    }

    /**
     * lateinit 推迟属性初始化。必须用var来修饰，不能用val
     * 使用 lateinit 时，您应尽快初始化属性，避免出现NullPointerException
     */
    private lateinit var userName: String
    private lateinit var userNameTextView: TextView


    /**
     * SAM转换
     * SAM 转换可使代码明显变得更简洁
     * 给按钮button设置了一个点击监听
     * 当用户点击 button 时，系统会执行传递给 setOnClickListener() 的匿名函数中的代码
     */
//    btClick.setOnClickListener
//    {
//
//    }

    /**
     * 伴生对象：java中的静态
     * 用于定义在概念上与某个类型相关但不与特定对象关联的变量或函数。
     * 伴生对象类似于对变量和方法使用 Java 的 static 关键字
     *
     */
    companion object {
        private const val TAG = "MainActivity"
    }

    /**
     * 属性委托
     * 初始化属性时，您可能会重复 Android 的一些比较常见的模式，例如在 Fragment 中访问 ViewModel。
     * 为避免过多的重复代码，您可以使用 Kotlin 的属性委托语法。
     * 属性委托提供了一种可在您的整个应用中重复使用的通用实现
     * 属性委托使用反射，这样会增加一些性能开销。这种代价换来的是简洁的语法，可让您节省开发时间。
     */
    private val viewModel: ViewModel by viewModels()


    /**
     * 可为null性
     * Kotlin 提供了严格的可为 null 性规则，可在您的整个应用中维护类型安全。
     * 在 Kotlin 中，默认情况下，对对象的引用不能包含 null 值。
     * 如需为变量赋 null 值，必须通过将 ? 添加到基本类型的末尾以声明可为 null 变量类型。
     *   例如，以下表达式在 Kotlin 中是违反规则的。name 的类型为 String，不可为 null：
     */

//    val name2: String = null        // 不可为null

    // 如需允许 null 值，必须使用可为 null String 类型 String?
    val name2: String? = null    // 可为null性


    /**
     * 互操作性
     * kotlin 与 java 的互相调用
     * 可为 null 性是 Java 和 Kotlin 在行为上有所不同的一个主要方面。Java 对可为 null 性语法的要求不那么严格。
     */


    /**
     * 平台类型
     * 如果您使用 Kotlin 引用在 Java Account 类中定义的不带注释的 name 成员，
     * 编译器将不知道 String 映射到 Kotlin 中的 String 还是 String?。这种不明确性通过平台类型 String! 表示
     * String! 对 Kotlin 编译器而言没有特殊的含义。String! 可以表示 String 或 String?，编译器可让您赋予任一类型的值。
     * 请注意，如果您将类型表示为 String 并赋予 null 值，则系统可能会抛出 NullPointerException。
     *
     *  为了解决此问题，每当您用 Java 编写代码时，都应使用可为 null 性注释。这些注释对 Java 和 Kotlin 开发者都有帮助
     *  private final @Nullable String userName;
     *  这表示它可以持有 null 值。于是，Kotlin 会将 userName 视为 String?
     *
     *  如需指明变量绝不能为 null，请使用 @NonNull 注释
     *  public final @NonNull String userName;
     *  在这种情况下，userName 在 Kotlin 中被视为不可为 null String
     */


    /**
     *  处理可为 null 性
     *  非 null 断言运算符 !!
     *  !! 运算符将其左侧的所有内容视为非 null，因此，在本例中，应将 name 视为非 null String。
     *  如果它左侧表达式的结果为 null，则您的应用会抛出 NullPointerException。
     *  此运算符简单快捷，但应谨慎使用，因为它会将 NullPointerException 的实例重新引入您的代码；
     *  更安全的选择是使用安全调用运算符 ?.
     *
     *  使用安全调用运算符时，如果 name 不为 null，则 name?.trim() 的结果是一个不带前导或尾随空格的名称值。
     *  如果 name 为 null，则 name?.trim() 的结果为 null。
     *  这意味着，在执行此语句时，您的应用永远不会抛出 NullPointerException。
     *
     *  虽然安全调用运算符可使您避免潜在的 NullPointerException，但它会将 null 值传递给下一个语句。
     *  您可以使用 Elvis 运算符 (?:) 紧接着处理 null 值的情况，如以下示例所示：
     */

    // !! 运算符将其左侧的所有内容视为非 null,如果它左侧表达式的结果为 null，则您的应用会抛出 NullPointerException。
    val account = Account("name", "type")
    val accountName = account.name!!.trim()

    // 更安全的选择是使用安全调用运算符 ?.
    val account1 = Account("name", "type")
    val accountName1 = account1.name?.trim()


    // 使用 Elvis 运算符 (?:) 紧接着处理 null 值的情况;
    // 如果 Elvis 运算符左侧表达式的结果为 null，则会将右侧的值赋予 accountName2
    val account2 = Account("name", "type")
    val accountName2 = account2.name?.trim() ?: "Default name"


    /**
     * 使用 Elvis 运算符提前从函数返回结果
     */
    fun validateAccount(account: Account?) {
        val accountName = account?.name?.trim() ?: "Default name"

        // account cannot be null beyond this point
        account ?: return
    }


    /**
     * 属性初始化
     * 默认情况下，Kotlin 中的属性并未初始化。当初始化属性的封闭类时，必须初始化属性
     */
    class LoginFragment1 : Fragment() {
        val index: Int = 12
        val index2: Int


        // 在构建 LoginFragment1 时初始化 index2
        init {
            index2 = 12
        }
    }


    fun getLock() {
        var person = person3(22)
    }

    override fun onThemeChanged(event: ThemeManager.OnThemeChangedEvent?) {

    }


}



