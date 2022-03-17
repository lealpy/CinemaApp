package com.lealpy.cinemaapp.presentation.screens.movies.view

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MoviesItemDecoration(
    private val adapter: MoviesAdapter,
    private val verticalSpacing: Int,
    private val horizontalSpacing: Int,
) :
    RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State,
    ) {
        val position = parent.getChildAdapterPosition(view)
            .let { position ->
                if (position == RecyclerView.NO_POSITION) {
                    return
                } else {
                    position
                }
            }

        when (adapter.getItemViewType(position)) {
            MoviesAdapter.ViewType.CHAPTER_ITEM.ordinal -> {
                if (position == 0) {
                    outRect.top = verticalSpacing
                }
                if (position != state.itemCount - 1) {
                    outRect.bottom = verticalSpacing
                }
            }
            MoviesAdapter.ViewType.GENRE_ITEM.ordinal -> {
                outRect.left = horizontalSpacing
                outRect.right = horizontalSpacing
                if (position != state.itemCount - 1) {
                    outRect.bottom = verticalSpacing
                }
            }
            MoviesAdapter.ViewType.MOVIE_ITEM.ordinal -> {
                val column = position % MOVIES_ITEMS_SPAN_COUNT
                outRect.left =
                    horizontalSpacing - column * horizontalSpacing / MOVIES_ITEMS_SPAN_COUNT
                outRect.right = (column + 1) * horizontalSpacing / MOVIES_ITEMS_SPAN_COUNT
                outRect.bottom = verticalSpacing
            }
        }
    }

    companion object {
        private const val MOVIES_ITEMS_SPAN_COUNT = 2
    }

}
