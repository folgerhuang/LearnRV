package com.jkxy.learnrv;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jkxy.learnrv.Domain.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yushi on 6/18/16.
 */
class MyAdapter extends RecyclerView.Adapter {
//    private String[] arrayItem=new String[]{"hello","jikexueyuan","Stome","Jack"};

    private static List<Book> books=new ArrayList<Book>();

    static {
        books.add(new Book("围城", "这是一本好书"));
        books.add(new Book("三国演义", "这也是一本好书"));
        books.add(new Book("红楼梦", "我很喜欢看"));
        books.add(new Book("水浒传", "这本书我看了3遍"));
        books.add(new Book("薛仁贵", "很好看"));

    }

    private MainActivity mainActivity;

    public MyAdapter(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle,tvContent;

        public ViewHolder(View root) {
            super(root);
            tvTitle= (TextView) root.findViewById(R.id.tvTitle);
            tvContent= (TextView) root.findViewById(R.id.tvContent);
        }

        public TextView getTvTitle() {
            return tvTitle;
        }

        public TextView getTvContent() {
            return tvContent;
        }

        public void setTvTitle(TextView tvTitle) {
            this.tvTitle = tvTitle;
        }

        public void setTvContent(TextView tvContent) {
            this.tvContent = tvContent;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.listcell,null));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;
        viewHolder.tvTitle.setText(books.get(position).getTitle());
        viewHolder.tvContent.setText(books.get(position).getContent());


    }

    @Override
    public int getItemCount() {
        return books.size();
    }
}
