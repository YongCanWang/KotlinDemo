package com.example.kotlindemo.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.widget.SwitchCompat
import androidx.fragment.app.Fragment
import com.example.kotlindemo.MyApplication
import com.example.kotlindemo.R
import com.example.kotlindemo.utils.ThemeManager

/**
 * @author TomCan
 * @description:
 * @date:2021/11/19 16:16
 */
class SettingPageFragment : Fragment(), CompoundButton.OnCheckedChangeListener {
    private lateinit var btClick: Button
    private lateinit var swDaynight: Switch


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return View.inflate(context, R.layout.fragment_setting_page, null)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btClick = view.findViewById(R.id.bt_click)
        swDaynight = view.findViewById(R.id.sw_daynight)
        var scDaynight = view.findViewById<SwitchCompat>(R.id.sc_daynight)


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


        swDaynight.setOnCheckedChangeListener { compoundButton, b ->
            if (b == MyApplication.isDayNight) return@setOnCheckedChangeListener
            MyApplication.isDayNight = b
            activity!!.recreate()
        }


        scDaynight.setOnCheckedChangeListener { compoundButton, b ->
            val theme =
                (ThemeManager.getInstance().currentTheme + 1) % ThemeManager.getInstance().themeCount
            ThemeManager.getInstance().setCurrentTheme(theme)
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

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean) {
        Log.e("wyc", "onCheckedChanged:" + p1)
        if (p1 == MyApplication.isDayNight) return
        MyApplication.isDayNight = p1
        Log.e("wyc", MyApplication.isDayNight.toString())
        activity!!.recreate()
        activity!!.supportFragmentManager.popBackStack()
        Log.e("wyc2", MyApplication.isDayNight.toString())
    }

}