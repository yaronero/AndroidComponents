package com.example.androidcomponents.presentation.selecteditem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.databinding.FragmentSelectedItemBinding
import java.lang.RuntimeException

class SelectedItemFragment : Fragment() {

    private lateinit var binding: FragmentSelectedItemBinding

    private val viewModel by lazy {
        ViewModelProvider(this)[SelectedItemViewModel::class.java]
    }

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

        val item = arguments?.getInt(ITEM_ID)?.let { viewModel.getItemById(it) }
            ?: throw RuntimeException("Item id is null")

        with(binding) {
            selectedItemId.text = getString(R.string.selected_id, item.id.toString())
            selectedItemName.text = getString(R.string.selected_name, item.name)
            selectedItemDescription.text =
                getString(R.string.selected_description, item.description)
        }
    }

    companion object {

        private const val ITEM_ID = "item_id"

        fun newInstance(id: Int): Fragment {
            return SelectedItemFragment().apply {
                arguments = bundleOf(ITEM_ID to id)
            }
        }
    }
}