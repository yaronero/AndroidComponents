package com.example.androidcomponents.presentation.itemlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.FragmentItemListBinding
import com.example.androidcomponents.domain.Item
import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.PREFS_ITEM

class ItemListFragment : Fragment(), ItemListContractView {

    private lateinit var binding: FragmentItemListBinding

    private val presenter by lazy {
        val sharedPrefs = activity?.getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)
            ?: throw RuntimeException("Activity is null")

        ItemListPresenter(sharedPrefs)
    }

    private val adapter by lazy {
        ItemListAdapter(::onItemClickListener)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupItemAdapter()
        presenter.loadItemList()
    }

    private fun setupItemAdapter() {
        binding.rvItemList.adapter = adapter
    }

    override fun showItemList(list: List<Item>) {
        adapter.submitList(list)
    }

    private fun onItemClickListener(id: Int) {
        presenter.putItemIdInPrefs(id)

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container, SelectedItemFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.detachView()
    }

    companion object {

        fun newInstance(): Fragment {
            return ItemListFragment()
        }
    }
}