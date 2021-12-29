package stronov.lab1

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import stronov.lab1.databinding.FragmentMainBinding

class MainFragment : Fragment() {
    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        super.onViewCreated(view, savedInstanceState)

        confirmButton.setOnClickListener {
            val questionText = edit.text.toString()
            val answerText = when (radioGroup.checkedRadioButtonId) {
                optionYes.id -> getString(R.string.yes)
                optionNo.id -> getString(R.string.no)
                else -> ""
            }
            when {
                questionText.isEmpty() -> toast(R.string.no_question_error)
                answerText.isEmpty() -> toast(R.string.no_answer_error)
                else -> {
                    val fragment = ResultFragment.newInstance(questionText, answerText)
                    parentFragmentManager.commit {
                        setReorderingAllowed(true)
                        replace(R.id.fragment_container_view, fragment)
                        addToBackStack(null)
                    }
                }
            }
        }
    }

    private fun toast(strRes: Int) {
        Toast.makeText(requireContext(), getString(strRes), Toast.LENGTH_SHORT).show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}