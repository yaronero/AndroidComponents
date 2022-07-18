package com.example.androidcomponents.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.FragmentItemListBinding

class ItemListFragment : Fragment() {

    private val binding by lazy {
        FragmentItemListBinding.inflate(layoutInflater)
    }

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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupItemAdapter()
        viewModel.list.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    private fun setupItemAdapter(){
        binding.rvItemList.adapter = adapter
    }

    private fun onItemClickListener(id: Int){
        parentFragmentManager
            .beginTransaction()
            .add(R.id.container, SelectedItemFragment.newInstance(id))
            .addToBackStack(null)
            .commit()
    }

    companion object {

        fun newInstance(): Fragment {
            return ItemListFragment()
        }
    }
}