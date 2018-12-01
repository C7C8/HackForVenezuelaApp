package wpi.kgcm.hackforvenezuela;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PostAdapter extends BaseAdapter {

    private ArrayList<Post> postList;
    private Context context;

    public PostAdapter(ArrayList<Post> list, Context cont) {
        this.postList = list;
        this.context = cont;
    }

    @Override
    public int getCount() {
        return this.postList.size();
    }

    @Override
    public Object getItem(int position) {
        return this.postList.get(position);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    private static class ViewHolder {
        private TextView title;
        private TextView author;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inf.inflate(R.layout.row_layout, null);

            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.text_title);
            holder.author = (TextView) convertView.findViewById(R.id.text_author);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.title = (TextView) convertView.findViewById(R.id.text_title);
        holder.author = (TextView) convertView.findViewById(R.id.text_author);


        Post post = postList.get(position);
        holder.title.setText(post.getTitle());
        holder.author.setText(post.getAuthor());

        return convertView;
    }
}