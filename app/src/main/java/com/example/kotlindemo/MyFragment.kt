package com.example.kotlindemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

/**
 * @author TomCan
 * @description:
 * @date:2021/11/19 16:16
 */
class MyFragment : Fragment() {
    private lateinit var btClick: Button


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_myfragment, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btClick = view.findViewById(R.id.bt_click)
        btClick.setOnClickListener {
            val person = Person()
            person.name.trim()
            person.description = "王菲是亚洲天后~~~" // 声明Person类对象后，才对description变量进行赋值操作
            /**
             * 由于声明description变量时初始化为null，赋值为null所以Kotlin编译器会提示报错，
             * 建议加入!!非null断言运算符
             */
//            person.description.trim() // 该行代码会报错。暂时注释掉
            /**
             * 加入!!非null断言运算符
             * !! 运算符将其左侧的所有内容视为非 null，如果它左侧表达式的结果为 null，
             * 则您的应用会抛出 NullPointerException。此运算符简单快捷，但应谨慎使用，
             * 因为它会将 NullPointerException 的实例重新引入您的代码。
             */
//            var content = person.description!!.trim()
            /**
             * 使用安全调用运算符时，如果 name 不为 null，则 name?.trim() 的结果是一个不带前导或尾随空格的名称值。
             * 如果 name 为 null，则 name?.trim() 的结果为 null。这意味着，在执行此语句时，您的应用永远不会抛出 NullPointerException。
             */
            var content = person.description?.trim()

            Toast.makeText(context, content, Toast.LENGTH_LONG).show()
        }

        val person = Person()
        if (person.age > 18) return
        when (person.age) {
            10 -> return
        }




    }


    class Person {
        var name: String
        var age: Int
        var description: String?

        init {
            name = "王菲"
            age = 12
            description = null // 赋值为null
        }
    }

}