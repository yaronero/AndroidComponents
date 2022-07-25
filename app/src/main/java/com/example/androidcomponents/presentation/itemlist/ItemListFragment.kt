package com.example.androidcomponents.presentation.itemlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.domain.itemList.GetItemListUseCase
import com.example.androidcomponents.databinding.FragmentItemListBinding
import com.example.androidcomponents.domain.itemList.PutIdInPrefsUseCase
import com.example.androidcomponents.presentation.factories.ItemListViewModelFactory
import com.example.androidcomponents.presentation.itemlist.adapter.ItemListAdapter
import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.PREFS_ITEM

class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val viewModel by lazy {
        val sharedPref =
            activity?.getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)
                ?: throw RuntimeException("Activity is null")

        val factory = ItemListViewModelFactory(
            setOf(
                GetItemListUseCase(),
                PutIdInPrefsUseCase(sharedPref)
            ),
            sharedPref
        )
        ViewModelProvider(this, factory)[ItemListViewModel::class.java]
    }

    private val adapter by lazy {
        ItemListAdapter(::onItemClickListener)
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

        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        viewModel.loadList()
    }

    private fun renderState(state: ItemListState) {
        adapter.submitList(state.list)
    }

    private fun setupItemAdapter() {
        binding.rvItemList.adapter = adapter
    }

    private fun onItemClickListener(id: Int) {
        viewModel.putItemIdInPrefs(id)

        parentFragmentManager
            .beginTransaction()
            .replace(R.id.container, SelectedItemFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        fun newInstance(): Fragment {
            return ItemListFragment()
        }
    }
}