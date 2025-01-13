package com.example.demoapp.presentation.allTasks

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapp.R
import com.example.demoapp.data.entity.Tasks

data class TaskItem(
    val date: String,
    val taskName: String,
    val priority: String
)

class AllTaskAdapter(private var tasks: List<Tasks>, private val taskAdapterListener: TaskAdapterListener) :
    RecyclerView.Adapter<AllTaskAdapter.TaskViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_task, parent, false) // Replace with your actual layout file name
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.bind(tasks[position])
    }

    override fun getItemCount(): Int = tasks.size

    fun setData(tasks: List<Tasks>) {
        this.tasks = tasks
    }

    // ViewHolder class for the task card
    inner class TaskViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val taskDate: TextView = itemView.findViewById(R.id.text_task_date)
        private val taskName: TextView = itemView.findViewById(R.id.text_task_name)
        private val taskPriority: TextView = itemView.findViewById(R.id.text_task_priority)

        // Bind the task data to the views
        fun bind(taskItem: Tasks) {
            itemView.setOnClickListener {
                taskAdapterListener.openTask(taskItem)
            }
            taskDate.text = taskItem.date.toString()
            taskName.text = taskItem.name
            taskPriority.text = taskItem.priority.toString()
        }
    }

    interface TaskAdapterListener {
        fun openTask(taskItem: Tasks)
    }
}
