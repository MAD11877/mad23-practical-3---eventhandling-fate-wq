package sg.edu.np.mad.week2t04.practical3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private TextView Name;
    private TextView Description;

    private Button FollowButton;
    private Button MessageButton;
    private User user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Name = findViewById(R.id.textView);
        Description= findViewById(R.id.lorem_ipsum_textview);
        FollowButton = findViewById(R.id.btn2);
        MessageButton = findViewById(R.id.btn3);

        // Load data from the User object
        User user = new User("Bryan", "Lorem ipsum dolor sit amet", 1, false); // Replace this with your own code to get the User object
        Name.setText(user.getName());
        Description.setText(user.getDescription());
        int randomNumber = getIntent().getIntExtra("randomNumber", 0);

        // Append the random number to the name text
        String fullName = user.getName() + " (" + randomNumber + ")";
        Name.setText(fullName);

        // Set the text of the Follow button based on the value of the followed variable
        if (user.isFollowed()) {
            FollowButton.setText("Unfollow");
        } else {
            FollowButton.setText("Follow");
        }

        // Set an OnClickListener for the Follow button
        FollowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Toggle the value of the followed variable
                user.setFollowed(!user.isFollowed());

                // Update the text of the Follow button
                if (user.isFollowed()) {
                    Toast.makeText(MainActivity.this,"Followed!",Toast.LENGTH_SHORT).show();
                    FollowButton.setText("Unfollow");
                } else {
                    Toast.makeText(MainActivity.this,"Unfollowed!",Toast.LENGTH_SHORT).show();
                    FollowButton.setText("Follow");
                }
            }
        });
        MessageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MessageGroup.class);
                startActivity(intent);
            }
        });
    }
}
