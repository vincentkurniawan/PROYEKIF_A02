package id.ac.unpar.proif.northstar_october.View

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import id.ac.unpar.proif.northstar_october.Model.Box
import id.ac.unpar.proif.northstar_october.databinding.FragmentFillOrderBinding


class fill_order : Fragment( ), View.OnClickListener {
    lateinit var selectedItems: ArrayList<Box>
    lateinit var binding:FragmentFillOrderBinding

    companion object {
        fun newInstance (selectedItems: ArrayList<Box>):fill_order {
            val fragment = fill_order()
            fragment.selectedItems=selectedItems
            return fragment;
        }

    }


    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                                savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        this.binding= FragmentFillOrderBinding.inflate(layoutInflater)
        var orderAdapter= FillOrderAdapter(requireActivity());
        orderAdapter.loadData(this.selectedItems)
        binding.lvFillOrder.adapter=orderAdapter

        binding.ivBack.setOnClickListener(this)
        binding.pay.setOnClickListener(this)


        return binding.root;
    }

    override fun onClick(p0: View?) {
        if(p0==binding.ivBack){
            val result = Bundle()
            result.putInt("page", -11) //NUMBER PAGE SEBELUMNYA
            parentFragmentManager.setFragmentResult("CHANGE_PAGE", result)
        }else if(p0==binding.pay){

        }
    }


}