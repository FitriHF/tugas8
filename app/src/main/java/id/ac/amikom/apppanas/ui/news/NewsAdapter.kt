package id.ac.amikom.apppanas.ui.news

import android.content.Context
import android.content.Intent
import android.widget.BaseAdapter
import androidx.databinding.ViewDataBinding
import com.bumptech.glide.Glide
import id.ac.amikom.apppanas.R
import id.ac.amikom.apppanas.data.model.News
import id.ac.amikom.apppanas.databinding.ItemNewsBinding
import id.ac.amikom.apppanas.ui.base.BaseAdaper

class NewsAdapter(val context: Context) : BaseAdaper<News>(R.layout.item_news) {
    override fun onBind(binding: ViewDataBinding?, data: News) {
        val mBinding = binding as ItemNewsBinding
        Glide.with(context).load(data.strCategoryThumb).into(mBinding.itemPoster)
    }

    override fun onClick(binding: ViewDataBinding?, data: News) {
        val intent = Intent(context, NewsActivity::class.java)
        intent.putExtra(NewsActivity.OPEN_NEWS, data)
        context.startActivity(intent)
    }
}

