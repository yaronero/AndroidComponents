package com.example.androidcomponents.presentation.selecteditem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.androidcomponents.R
import com.example.androidcomponents.data.usecases.GetItemByIdUseCase
import com.example.androidcomponents.databinding.FragmentSelectedItemBinding
import com.example.androidcomponents.presentation.factories.ItemDetailsViewModelFactory

class SelectedItemFragment : Fragment() {

    private lateinit var binding: FragmentSelectedItemBinding

    private val viewModel by lazy {
        val itemId = arguments?.getInt(ITEM_ID)!!

        val factory = ItemDetailsViewModelFactory(
            setOf(
                GetItemByIdUseCase()
            ),
            itemId
        )
        ViewModelProvider(this, factory)[SelectedItemViewModel::class.java]
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

        viewModel.state.observe(viewLifecycleOwner, ::renderState)
        viewModel.loadItem()
    }

    private fun renderState(newState: SelectedItemState) {
        newState.item?.also {
            with(binding) {
                selectedItemId.text = getString(R.string.selected_id, it.id.toString())
                selectedItemName.text = getString(R.string.selected_name, it.name)
                selectedItemDescription.text =
                    getString(R.string.selected_description, it.description)
            }
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