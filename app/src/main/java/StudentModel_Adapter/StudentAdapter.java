package StudentModel_Adapter;

import android.graphics.drawable.RippleDrawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.rokan.humaclab.studentprofile.R;
import com.rokan.humaclab.studentprofile.db.Student;
import com.rokan.humaclab.studentprofile.db.StudentDao;

import java.util.List;


public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.Holder> {

    private List<Student> mData;
    public StudentAdapter( List<Student> students){
        this.mData = students;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_layout, parent, false);
        Holder holder = new Holder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

        holder.mName.setText(mData.get(position).getName());
        holder.mSubject.setText(mData.get(position).getSubject());
        holder.mCGPA.setText(Double.toString(mData.get(position).getCgpa()));
        holder.mUniversity.setText(mData.get(position).getUniversity());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class Holder extends RecyclerView.ViewHolder {
        private ImageView mImageView;
        private TextView mName, mDob, mSubject, mCGPA, mUniversity;

        public Holder(View itemView) {
            super(itemView);

            mImageView = (ImageView) itemView.findViewById(R.id.student_imageView);
            mName = (TextView) itemView.findViewById(R.id.tvName);
            mSubject = (TextView) itemView.findViewById(R.id.tvSubject);
            mCGPA = (TextView) itemView.findViewById(R.id.tvCGPA);
            mUniversity = (TextView) itemView.findViewById(R.id.tvUniversity);

        }
    }

}
