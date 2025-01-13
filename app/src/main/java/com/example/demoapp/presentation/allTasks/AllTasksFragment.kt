package com.example.demoapp.presentation.allTasks

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import com.example.demoapp.data.entity.Tasks
import com.example.demoapp.databinding.FragmentAllTasksBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class AllTasksFragment : Fragment(), AllTaskAdapter.TaskAdapterListener {

    private var _binding: FragmentAllTasksBinding? = null
    // private val viewModel: AllTasksViewModel by viewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentAllTasksBinding.inflate(inflater, container, false)
        initRecycler()
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.fabCreateTask.setOnClickListener {
            findNavController().navigate(AllTasksFragmentDirections.actionAllTasksFragmentToEditTaskFragment(-1L))
        }
    }

    private fun initRecycler() {
        val factory = AllTasksViewModel.AllTasksViewModelFactory(activity?.application!!)
        val viewModel = ViewModelProvider(this, factory)[AllTasksViewModel::class]
        val vLayoutManager: RecyclerView.LayoutManager =
            LinearLayoutManager(requireContext())
        val allTaskAdapter = AllTaskAdapter(emptyList(), this@AllTasksFragment)
        binding.recyclerAllTask.layoutManager = vLayoutManager
        binding.recyclerAllTask.itemAnimator = DefaultItemAnimator()
        binding.recyclerAllTask.adapter = allTaskAdapter
        (binding.recyclerAllTask.itemAnimator as SimpleItemAnimator).supportsChangeAnimations =
            false
            // val allTask = viewModel.getAllTask()
        viewModel.getAllTask().observe(viewLifecycleOwner) { allTask ->
            allTaskAdapter.setData(allTask)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun openTask(taskItem: Tasks) {
        findNavController().navigate(AllTasksFragmentDirections.actionAllTasksFragmentToEditTaskFragment(taskItem.id))
    }
}