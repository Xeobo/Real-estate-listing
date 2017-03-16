package com.rt_rk.vzbiljic.pkiapp.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rt_rk.vzbiljic.pkiapp.R;
import com.rt_rk.vzbiljic.pkiapp.adapters.DetailsAdapterListView;
import com.rt_rk.vzbiljic.pkiapp.adapters.SpinerPagerAdapter;
import com.rt_rk.vzbiljic.pkiapp.bean.Comment;
import com.rt_rk.vzbiljic.pkiapp.bean.User;
import com.rt_rk.vzbiljic.pkiapp.datasource.ActivityDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.PropertyDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.UserDataSource;
import com.rt_rk.vzbiljic.pkiapp.datasource.manager.ActivityDataSourceManager;
import com.rt_rk.vzbiljic.pkiapp.datasource.manager.CommentDataSourceManager;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailsFragment extends Fragment implements OnMapReadyCallback {
    private static final String TAG = "DetailsFragment";
    private final int currentUserID;
    private SpinerPagerAdapter spinerPagerAdapter;
    private ViewPager viewPager;
    private MapView mapView;
    private GoogleMap googleMap;
    private User currentUser;
    private int currentPropertyID = 0;

    private void refreshFragment(){
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.detach(DetailsFragment.this).attach(DetailsFragment.this).commit();
    }


    private void initializeActivityTable(View root, final LayoutInflater inflater){

        TableLayout table = (TableLayout) root.findViewById(R.id.table_activity);

        for (int i = 0; i < ActivityDataSourceManager.getInstance().getDataSource(currentUserID).getDescription().length; i++) {


            TableRow row = (TableRow)inflater.inflate(R.layout.fragment_details_attrib_row, null);
            ((TextView)row.findViewById(R.id.dateTextView)).setText(ActivityDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getDatum());
            ((TextView)row.findViewById(R.id.userTextView)).setText(ActivityDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getUser());
            ((TextView)row.findViewById(R.id.agentTextView)).setText(ActivityDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getAgent());
            ((TextView)row.findViewById(R.id.typeTextView)).setText(ActivityDataSourceManager.getInstance().getDataSource(currentUserID).get(i).toString());

            row.setTag(i);

            row.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TextView tv = (TextView)v.findViewById(R.id.userTextView);

                    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                    View mView = inflater.inflate(R.layout.fragment_details_dialog_activity,null);


                    final TableRow clickedRow = (TableRow) v;


                    //date
                    TextView dialogText = (TextView) mView.findViewById(R.id.dialog_date);
                    dialogText.setText(dialogText.getText() + " " +((TextView) v.findViewById(R.id.dateTextView)).getText());

                    //user
                    dialogText = (TextView) mView.findViewById(R.id.dialog_user);
                    dialogText.setText(dialogText.getText() + " " +((TextView) v.findViewById(R.id.userTextView)).getText());

                    //agent
                    dialogText = (TextView) mView.findViewById(R.id.dialog_agent);
                    dialogText.setText(dialogText.getText() + " " +((TextView) v.findViewById(R.id.agentTextView)).getText());

                    //type
                    dialogText = (TextView) mView.findViewById(R.id.dialog_type);
                    dialogText.setText(dialogText.getText() + " " +((TextView) v.findViewById(R.id.typeTextView)).getText());

                    builder.setView(mView);

                    ListView lv = (ListView)mView.findViewById(R.id.details_list);
                    lv.setAdapter(new DetailsAdapterListView(getActivity()));



                    final AlertDialog dialog = builder.create();
                    dialog.show();


                    lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            switch (position){
                                case 0://EDIT
                                    FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();

                                    // Replace whatever is in the fragment_container view with this fragment,
                                    // and add the transaction to the back stack so the user can navigate back
                                    transaction.replace(R.id.fragment_container, new AddActivityFragment());
                                    transaction.addToBackStack(null);

                                    // Commit the transaction
                                    transaction.commit();
                                    break;
                                case 1://ACCEPT

                                    break;
                                case 2://DELETE
                                    int positionInTable = (Integer) clickedRow.getTag();
                                    ActivityDataSourceManager.getInstance().getDataSource(currentUserID).remove(positionInTable);

                                    Toast.makeText(getActivity(),"position: " + positionInTable,Toast.LENGTH_SHORT).show();

                                    refreshFragment();
                                    break;
                                default:

                                    break;
                            }
                            dialog.dismiss();
                        }
                    });


                }
            });

            table.addView(row);



        }
    }


    private void initializeDetails(View root){
        ((TextView)root.findViewById(R.id.detailsHeader)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getName());
        ((TextView)root.findViewById(R.id.cena)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getPrice());
        ((TextView)root.findViewById(R.id.struktura)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getStructure());
        ((TextView)root.findViewById(R.id.sprat)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getFlor());
        ((TextView)root.findViewById(R.id.grejanje)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getHeating());
        ((TextView)root.findViewById(R.id.terasa)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getTerrace());
        ((TextView)root.findViewById(R.id.type)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getType());
        ((TextView)root.findViewById(R.id.datumUnosa)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getDateFrom());
        ((TextView)root.findViewById(R.id.uknjizeno)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getBooked());
        ((TextView)root.findViewById(R.id.status)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getStatus());
//        ((TextView)root.findViewById(R.id.area)).setText(PropertyDataSource.getInstance().get(currentPropertyID).getSurfaceArea());
    }

    private void initializeCommentTable(View root, LayoutInflater inflater){
        final LinearLayout table = (LinearLayout) root.findViewById(R.id.comment_layout);
        final View finalroot = root;
        for (int i = 0; i < CommentDataSourceManager.getInstance().getDataSource(currentUserID).getDescription().length; i++) {
            final RelativeLayout view = (RelativeLayout) inflater.inflate(R.layout.fragment_details_comment_row, null);

            Log.i(TAG,"i = " + i + ", text = " + CommentDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getComment());

            ((TextView)view.findViewById(R.id.commentTextView)).setText(CommentDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getComment());
            ((TextView)view.findViewById(R.id.commentDate)).setText(CommentDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getUser() + " " + CommentDataSourceManager.getInstance().getDataSource(currentUserID).get(i).getDate());


            table.addView(view);

        }

        (finalroot.findViewById(R.id.add_comment)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Button button = (Button)v;

                String text = ((EditText)finalroot.findViewById(R.id.input_comment)).getText().toString();

                ((EditText)finalroot.findViewById(R.id.input_comment)).setText("");

                if(text.equals("")){
                    Toast.makeText(getActivity(),"Unesite prvo tekst komentara",Toast.LENGTH_SHORT).show();
                }else{
                    long milis = System.currentTimeMillis();
                    SimpleDateFormat sdf = new SimpleDateFormat("HH:mm MMM dd.YYYY.", Locale.ENGLISH);
                    String date = sdf.format(new Date(milis));

                    CommentDataSourceManager.getInstance().getDataSource(currentUserID).add(new Comment(text,"user",date));


                    refreshFragment();
                }
            }
        });
    }

    private void initializeMaps(View root, Bundle savedInstanceState) {
        mapView = (MapView) root.findViewById(R.id.map);

        mapView.onCreate(savedInstanceState);

        mapView.onResume();

        mapView.getMapAsync(this);

        try {
            MapsInitializer.initialize(getActivity().getApplicationContext());
        } catch (Exception e) {
            Log.e(TAG, "Couldn't initialize maps. :(");
        }

        final ScrollView scroll = (ScrollView) root.findViewById(R.id.scroll);
        ImageView transparent = (ImageView)root.findViewById(R.id.imagetrans);

        transparent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        scroll.requestDisallowInterceptTouchEvent(true);
                        // Disable touch on transparent view
                        return false;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        scroll.requestDisallowInterceptTouchEvent(false);
                        return true;

                    case MotionEvent.ACTION_MOVE:
                        scroll.requestDisallowInterceptTouchEvent(true);
                        return false;

                    default:
                        return true;
                }
            }
        });
    }

    public DetailsFragment() {
        // Required empty public constructor

        currentUser = UserDataSource.getInstance().getCurrentUser();

        currentUserID = UserDataSource.getInstance().getID(currentUser);
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_details, (FrameLayout) getActivity().findViewById(R.id.fragment_container), false);
        viewPager = (ViewPager) root.findViewById(R.id.view_pager);

        initializeMaps(root, savedInstanceState);

        initializeActivityTable(root,inflater);

        initializeCommentTable(root,inflater);

        initializeDetails(root);

        spinerPagerAdapter = new SpinerPagerAdapter(getActivity());
        viewPager.setAdapter(spinerPagerAdapter);

        ImageView arrowLeft = (ImageView) root.findViewById(R.id.imageBefore);
        ImageView arrowRight = (ImageView) root.findViewById(R.id.imageAfter);

        arrowLeft.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_LEFT);
            }
        });

        arrowRight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.arrowScroll(View.FOCUS_RIGHT);
            }
        });


        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        mapView.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
        mapView.onPause();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(GoogleMap map) {
        Log.i(TAG, "On map ready");

        googleMap = map;

        // For dropping a marker at a point on the Map
        LatLng sydney = new LatLng(-34, 151);
        googleMap.addMarker(new MarkerOptions().position(sydney).title("Marker Title").snippet("Marker Description"));

        // For zooming automatically to the location of the marker
        CameraPosition cameraPosition = new CameraPosition.Builder().target(sydney).zoom(12).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));
    }
}
