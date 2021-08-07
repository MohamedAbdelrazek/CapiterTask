package com.capiter.base.utils
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager

abstract class PaginationScrollListener : RecyclerView.OnScrollListener() {
    private val visibleThreshold = 6
    private var dy = -1

    override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
        super.onScrolled(recyclerView, dx, dy)
        this.dy = dy
    }


    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        var totalItemCount = recyclerView.layoutManager!!.itemCount
        var lastCompletelyVisibleItemPosition = -1
        if (recyclerView.layoutManager is LinearLayoutManager) {
            lastCompletelyVisibleItemPosition = (recyclerView
                .layoutManager as LinearLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
        } else if (recyclerView.layoutManager is GridLayoutManager) {
            lastCompletelyVisibleItemPosition = (recyclerView
                .layoutManager as GridLayoutManager?)!!.findLastCompletelyVisibleItemPosition()
        } else if (recyclerView.layoutManager is StaggeredGridLayoutManager) {
            val staggeredGridLayoutManager =
                recyclerView.layoutManager as StaggeredGridLayoutManager?
            totalItemCount = staggeredGridLayoutManager!!.itemCount
            val spanCount = IntArray(staggeredGridLayoutManager.spanCount)
            val lastVisibleItems =
                staggeredGridLayoutManager.findLastCompletelyVisibleItemPositions(spanCount)
            if (staggeredGridLayoutManager.spanCount == 1) {
                lastCompletelyVisibleItemPosition = lastVisibleItems[0]
            } else if (staggeredGridLayoutManager.spanCount == 2) {
                lastCompletelyVisibleItemPosition =
                    Math.max(lastVisibleItems[0], lastVisibleItems[1])
            } else if (staggeredGridLayoutManager.spanCount == 3) {
                lastCompletelyVisibleItemPosition = Math.max(
                    Math.max(
                        lastVisibleItems[0],
                        lastVisibleItems[1]
                    ), lastVisibleItems[2]
                )
            }
        }
        // (dy > 0) means RecyclerView Scrolling up
        if (lastCompletelyVisibleItemPosition >= 0  && newState == RecyclerView.SCROLL_STATE_IDLE && dy >= 0 && lastCompletelyVisibleItemPosition + visibleThreshold >= totalItemCount
        ) {
            loadMoreItems()
        }
    }

    protected abstract fun loadMoreItems()
}