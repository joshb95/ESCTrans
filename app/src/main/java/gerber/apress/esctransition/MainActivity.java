package gerber.apress.esctransition;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    String[] jobTile = {"Software Developer", "IT Security", "Load Balancer Engineer", "Senior Project Manager", "Linux Architect"};

    String[] location = {"High Wycombe", "Beaconsfield", "Slough", "High Wycombe", "Bracknell"};

    String[] salary = {"£25k-£45k", "Up to £500 per day", "Negotiable", "Competitive", "Negotiable"};

    String[] description = {"Posted: 14 Jan 2020, Closes: 14 Feb 2020 Looking for Software developers of all abilities.", "Posted: 10 Jan 2020, Closes: 01 Feb 2020 Looking for a lead to a 12 month project.",
    "Posted: 08 Jan 2020, Closes: 01 Feb 2020 Looking for an experienced Load Balancer Engineer.", "Posted: 02 Jan 2020, Closes: 28 Jan 2020 Looking for a Senior Project Manager with experience.",
    "Posted: 02 Jan 2020, Closes: 28 Jan 2020 Looking for a Linux Arcitect to join a young diverse team."};

    String[] space = {"","","","",""};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);

        CustomAdapter customAdapter = new CustomAdapter();

        listView.setAdapter(customAdapter);
    }

    class CustomAdapter extends BaseAdapter{

        @Override
        public int getCount(){
            return jobTile.length;
        }

        @Override
        public Object getItem(int i){
            return null;
        }

        @Override
        public long getItemId(int i){
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup){
            view = getLayoutInflater().inflate(R.layout.customlayout, null);

            TextView jobTitleTxt = (TextView)view.findViewById(R.id.jobTitleTxt);

            TextView locationTxt = (TextView)view.findViewById(R.id.locationTxt);

            TextView salaryTxt = (TextView)view.findViewById(R.id.salaryTxt);

            TextView descriptionTxt = (TextView)view.findViewById(R.id.descriptionTxt);

            TextView spaceTxt = (TextView)view.findViewById(R.id.spaceTxt);

            jobTitleTxt.setText(jobTile[i]);
            locationTxt.setText(location[i]);
            salaryTxt.setText(salary[i]);
            descriptionTxt.setText(description[i]);
            spaceTxt.setText(space[i]);

            return view;
        }
    }

    public void logout (View view){
        FirebaseAuth.getInstance().signOut(); //Will Log the user out
        startActivity(new Intent(getApplicationContext(),Login.class)); //sends the user to the Login Page
        finish();
    }

    public void account (View view){
        startActivity(new Intent(getApplicationContext(),MyAccount.class)); //sends the user to their account Page
        finish();
    }

}
