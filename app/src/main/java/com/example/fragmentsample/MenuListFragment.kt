package com.example.fragmentsample

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.FrameLayout
import android.widget.ListView
import android.widget.SimpleAdapter
import androidx.fragment.app.Fragment


/**
 * A simple [Fragment] subclass.
 * Use the [MenuListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class MenuListFragment : Fragment() {

    private var _isLayoutXLarge = true

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val menuTanksFrame = activity?.findViewById<FrameLayout>(R.id.menuThanksFrame)

        if (menuTanksFrame == null) {
            _isLayoutXLarge = false
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_menu_list, container, false)
        val lvMenu = view.findViewById<ListView>(R.id.lvMenu)

        val menuList: MutableList<MutableMap<String, Any>> = mutableListOf()

        var menu = mutableMapOf<String, Any>("name" to "唐揚げ定食", "price" to 800, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "生姜焼き定食", "price" to 820, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "焼肉定食", "price" to 900, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "親子丼定食", "price" to 790, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 920, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "カツ丼", "price" to 820, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "サラダ定食", "price" to 220, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "山芋定食", "price" to 520, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "生姜焼き定食", "price" to 820, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "焼肉定食", "price" to 900, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "親子丼定食", "price" to 790, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 920, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "カツ丼", "price" to 820, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "サラダ定食", "price" to 220, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "山芋定食", "price" to 520, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "焼肉定食", "price" to 900, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "親子丼定食", "price" to 790, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "ハンバーグ定食", "price" to 920, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "カツ丼", "price" to 820, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "サラダ定食", "price" to 220, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        menu = mutableMapOf("name" to "山芋定食", "price" to 520, "desc" to "唐揚げとサラダがつきます")
        menuList.add(menu)

        val from = arrayOf("name", "price")
        val to = intArrayOf(android.R.id.text1, android.R.id.text2)

        val adapter = SimpleAdapter(activity, menuList, android.R.layout.simple_list_item_2, from, to)

        lvMenu.adapter = adapter

        lvMenu.onItemClickListener = ListItemClickListener()
        return view
    }

    private inner class ListItemClickListener: AdapterView.OnItemClickListener {
        override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {
            val item = parent.getItemAtPosition(position) as MutableMap<String, Any>

            val menuName = item["name"] as String
            val menuPrice = item["price"] as Int

            val bundle = Bundle()

            bundle.putString("menuName", menuName)
            bundle.putString("menuPrice", "${menuPrice}円")

            if (_isLayoutXLarge) {
                fragmentManager?.beginTransaction()?.let {
                    val menuThanksFragment = MenuThanksFragment()

                    menuThanksFragment.arguments = bundle
                    it.replace(R.id.menuThanksFrame, menuThanksFragment)
                    it.commit()
                }

            } else {
                val intentToMenuThanks = Intent(activity, MenuThanksActivity::class.java)

                intentToMenuThanks.putExtras(bundle)

                startActivity(intentToMenuThanks)
            }

        }

    }
}