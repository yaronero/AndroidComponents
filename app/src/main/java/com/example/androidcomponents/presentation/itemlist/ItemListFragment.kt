package com.example.androidcomponents.presentation.itemlist

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.FragmentItemListBinding
import com.example.androidcomponents.presentation.selecteditem.SelectedItemFragment
import com.example.androidcomponents.utils.LAST_SELECTED_ITEM_ID
import com.example.androidcomponents.utils.PREFS_ITEM

class ItemListFragment : Fragment() {

    private lateinit var binding: FragmentItemListBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[MainViewModel::class.java]
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
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupItemAdapter() {
        binding.rvItemList.adapter = adapter
    }

    private fun onItemClickListener(id: Int) {
        val sharedPref =
            activity?.getSharedPreferences(PREFS_ITEM, Context.MODE_PRIVATE)
                ?: return

        sharedPref.edit {
            putInt(LAST_SELECTED_ITEM_ID, id)
        }

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