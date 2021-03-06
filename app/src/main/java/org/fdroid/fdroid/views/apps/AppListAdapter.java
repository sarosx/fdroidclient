package org.fdroid.fdroid.views.apps;

import android.database.Cursor;
import android.view.ViewGroup;

import org.fdroid.fdroid.R;
import org.fdroid.fdroid.data.App;
import org.fdroid.fdroid.data.Schema;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

class AppListAdapter extends RecyclerView.Adapter<StandardAppListItemController> {

    private Cursor cursor;
    private final AppCompatActivity activity;
    private final AppListItemDivider divider;

    AppListAdapter(AppCompatActivity activity) {
        this.activity = activity;
        divider = new AppListItemDivider(activity);
        setHasStableIds(true);
    }

    public void setAppCursor(Cursor cursor) {
        this.cursor = cursor;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public StandardAppListItemController onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StandardAppListItemController(activity, activity.getLayoutInflater()
                .inflate(R.layout.app_list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StandardAppListItemController holder, int position) {
        cursor.moveToPosition(position);
        final App app = new App(cursor);
        holder.bindModel(app);
    }

    @Override
    public long getItemId(int position) {
        cursor.moveToPosition(position);
        return cursor.getLong(cursor.getColumnIndex(Schema.AppMetadataTable.Cols.ROW_ID));
    }

    @Override
    public int getItemCount() {
        return cursor == null ? 0 : cursor.getCount();
    }

    @Override
    public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
        recyclerView.addItemDecoration(divider);
    }

    @Override
    public void onDetachedFromRecyclerView(@NonNull RecyclerView recyclerView) {
        recyclerView.removeItemDecoration(divider);
        super.onDetachedFromRecyclerView(recyclerView);
    }
}
