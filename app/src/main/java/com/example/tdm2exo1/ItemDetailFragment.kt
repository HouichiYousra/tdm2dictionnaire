package com.example.tdm2exo1

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.tdm2exo1.dummy.DummyContent
import kotlinx.android.synthetic.main.activity_item_detail.*
import kotlinx.android.synthetic.main.item_detail.*
import kotlinx.android.synthetic.main.item_detail.view.*
import kotlinx.android.synthetic.main.item_detail.view.image_view_drawable

/**
 * A fragment representing a single Item detail screen.
 * This fragment is either contained in a [ItemListActivity]
 * in two-pane mode (on tablets) or a [ItemDetailActivity]
 * on handsets.
 */
class ItemDetailFragment : Fragment() {

    /**
     * The dummy content this fragment is presenting.
     */
    private var item: DummyContent.DummyItem? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        arguments?.let {
            if (it.containsKey(ARG_ITEM_ID)) {
                // Load the dummy content specified by the fragment
                // arguments. In a real-world scenario, use a Loader
                // to load content from a content provider.
                item = DummyContent.ITEM_MAP[it.getString(ARG_ITEM_ID)]
                activity?.toolbar_layout?.title = item?.content

            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.item_detail, container, false)
        var image = R.drawable.n1
        when(item!!.id) {
            "1" -> image=R.drawable.n1
            "2" -> image=R.drawable.n2
            "3" -> image=R.drawable.n3
            "4" -> image=R.drawable.n4
            "5" -> image=R.drawable.n5
            "6" -> image=R.drawable.n6
        }
        // Show the dummy content as text in a TextView.
        item?.let {
            rootView.image_view_drawable.setImageDrawable(activity?.applicationContext?.let { it1 ->
                ContextCompat.getDrawable(
                    it1, // Context
                    image // Drawable
                )
            })
        }

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var son = R.raw.n1
        when(item!!.id) {
            "1" -> son=R.raw.n1
            "2" -> son=R.raw.n2
            "3" -> son=R.raw.n3
            "4" -> son=R.raw.n4
            "5" -> son=R.raw.n5
            "6" -> son=R.raw.n6
        }
        image_view_drawable.setOnClickListener {
            val song: MediaPlayer = MediaPlayer.create(activity!!.applicationContext, son)
            song.start()
        }
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val ARG_ITEM_ID = "item_id"
    }
}
