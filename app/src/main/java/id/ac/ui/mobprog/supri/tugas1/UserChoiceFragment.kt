package id.ac.ui.mobprog.supri.tugas1

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import kotlinx.android.synthetic.main.user_choice_fragment.*
import id.ac.ui.mobprog.supri.tugas1.MainActivity

class UserChoiceFragment : Fragment() {

    companion object {
        fun newInstance() = UserChoiceFragment()
    }

    private lateinit var viewModel: UserChoiceViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.user_choice_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(UserChoiceViewModel::class.java)
        customerChoice.setOnClickListener{
            setChoice(viewModel, 1)
        }
        partnerChoice.setOnClickListener{
            setChoice(viewModel, 0)
        }
    }

    fun setChoice(viewModel: UserChoiceViewModel, index: Int) {
        viewModel.setUserChoiceData(viewModel.userChoiceList[index])
        (activity as MainActivity).showUserDetailsFragment()
    }
}