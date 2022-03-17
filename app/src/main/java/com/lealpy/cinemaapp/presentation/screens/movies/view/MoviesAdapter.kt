package com.lealpy.cinemaapp.presentation.screens.movies.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.lealpy.cinemaapp.R
import com.lealpy.cinemaapp.databinding.ItemChapterBinding
import com.lealpy.cinemaapp.databinding.ItemGenreBinding
import com.lealpy.cinemaapp.databinding.ItemMovieBinding
import com.lealpy.cinemaapp.presentation.models.Chapter
import com.lealpy.cinemaapp.presentation.models.RecyclerViewItem

class MoviesAdapter(
    private val onChapterItemClicked: (item: RecyclerViewItem.ChapterItem) -> Unit,
    private val onGenreItemClicked: (item: RecyclerViewItem.GenreItem) -> Unit,
    private val onMovieItemClicked: (item: RecyclerViewItem.MovieItem) -> Unit,
) : ListAdapter<RecyclerViewItem, RecyclerView.ViewHolder>(DiffCallback()) {

    inner class ChapterItemHolder(
        private val binding: ItemChapterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(chapterItem: RecyclerViewItem.ChapterItem) {
            binding.chapterTitle.text = chapterItem.chapter.title

            binding.root.setOnClickListener {
                onChapterItemClicked(chapterItem)
            }

            binding.chapterDropDown.visibility = when (chapterItem.chapter) {
                Chapter.GENRES -> View.VISIBLE
                Chapter.MOVIES -> View.INVISIBLE
            }
        }
    }

    inner class GenreItemHolder(
        private val binding: ItemGenreBinding,
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(genreItem: RecyclerViewItem.GenreItem) {
            binding.genreName.text = genreItem.genre.genreName

            binding.root.setOnClickListener {
                onGenreItemClicked(genreItem)
            }

            val backgroundColor = if (genreItem.isChecked) {
                itemView.context.getColor(R.color.item_genre_selected_color)
            } else {
                itemView.context.getColor(R.color.item_genre_unselected_color)
            }

            binding.genreCardView.setCardBackgroundColor(backgroundColor)
        }
    }

    inner class MovieItemHolder(
        private val binding: ItemMovieBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        private val requestManager = Glide.with(itemView.context)

        fun bind(movieItem: RecyclerViewItem.MovieItem) {
            binding.movieLocalizedName.text = movieItem.localizedName

            requestManager
                .load(movieItem.imageUrl)
                .placeholder(R.drawable.ic_baseline_no_photography_24)
                .error(R.drawable.ic_baseline_no_photography_24)
                .into(binding.movieImage)

            binding.root.setOnClickListener {
                onMovieItemClicked(movieItem)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is RecyclerViewItem.ChapterItem -> ViewType.CHAPTER_ITEM.ordinal
            is RecyclerViewItem.GenreItem -> ViewType.GENRE_ITEM.ordinal
            is RecyclerViewItem.MovieItem -> ViewType.MOVIE_ITEM.ordinal
            else -> throw Exception(EXCEPTION_MESSAGE)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ViewType.CHAPTER_ITEM.ordinal -> {
                ChapterItemHolder(
                    ItemChapterBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ViewType.GENRE_ITEM.ordinal -> {
                GenreItemHolder(
                    ItemGenreBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            ViewType.MOVIE_ITEM.ordinal -> {
                MovieItemHolder(
                    ItemMovieBinding.inflate(
                        LayoutInflater.from(parent.context),
                        parent,
                        false
                    )
                )
            }

            else -> throw Exception(EXCEPTION_MESSAGE)
        }

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = getItem(position)

        when (holder) {
            is ChapterItemHolder -> holder.bind(item as RecyclerViewItem.ChapterItem)
            is GenreItemHolder -> holder.bind(item as RecyclerViewItem.GenreItem)
            is MovieItemHolder -> holder.bind(item as RecyclerViewItem.MovieItem)
        }
    }

    class DiffCallback : DiffUtil.ItemCallback<RecyclerViewItem>() {
        override fun areItemsTheSame(oldItem: RecyclerViewItem, newItem: RecyclerViewItem) =
            oldItem.itemId == newItem.itemId

        override fun areContentsTheSame(oldItem: RecyclerViewItem, newItem: RecyclerViewItem) =
            oldItem == newItem
    }

    enum class ViewType {
        CHAPTER_ITEM,
        GENRE_ITEM,
        MOVIE_ITEM
    }

    companion object {
        private const val EXCEPTION_MESSAGE = "Unknown ViewType"
    }

}
