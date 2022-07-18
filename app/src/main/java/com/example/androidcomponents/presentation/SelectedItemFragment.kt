package com.example.androidcomponents.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.FragmentSelectedItemBinding
import com.example.androidcomponents.domain.Item

class SelectedItemFragment : Fragment() {

    private lateinit var binding: FragmentSelectedItemBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSelectedItemBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val item = arguments?.getParcelable<Item>(ITEM)

        with(binding){
            selectedItemId.text = getString(R.string.selected_id, item?.id.toString())
            selectedItemName.text = getString(R.string.selected_name, item?.name.toString())
            selectedItemDescription.text = getString(R.string.selected_description, item?.description.toString())
        }
    }

    companion object {

        private const val ITEM = "item"

        fun newInstance(context: Context, item: Item): Fragment {
            return SelectedItemFragment().apply{
                arguments = bundleOf(ITEM to item)
            }
        }
    }
}