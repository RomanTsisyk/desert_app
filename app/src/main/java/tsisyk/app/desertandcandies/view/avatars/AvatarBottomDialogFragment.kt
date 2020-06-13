package tsisyk.app.desertandcandies.view.avatars

import android.os.Bundle
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import androidx.recyclerview.widget.GridLayoutManager
import android.view.ViewGroup
import android.view.LayoutInflater
import android.view.View
import tsisyk.app.desertandcandies.R
import tsisyk.app.desertandcandies.model.Avatar
import kotlinx.android.synthetic.main.layout_avatar_bottom_sheet.*


class AvatarBottomDialogFragment : BottomSheetDialogFragment(), AvatarAdapter.AvatarListener {

    private lateinit var callback: AvatarAdapter.AvatarListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.layout_avatar_bottom_sheet, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        avatarRecyclerView.layoutManager = androidx.recyclerview.widget.GridLayoutManager(context, 5)
        avatarRecyclerView.adapter = AvatarAdapter(AvatarStore.AVATARS, this)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        try {
            callback = activity as AvatarAdapter.AvatarListener
        } catch (e: ClassCastException) {
            throw ClassCastException(activity.toString() + " must implement AvatarAdapter.AvatarListener")
        }
    }

    override fun avatarClicked(avatar: Avatar) {
        callback.avatarClicked(avatar)
    }

    companion object {
        fun newInstance(): AvatarBottomDialogFragment {
            return AvatarBottomDialogFragment()
        }
    }
}