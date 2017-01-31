package com.kaivanshah.assignment33;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_UploadImage;
    ImageView ImageView_Upload;
    int IMAGE_DISPLAY = 1;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_UploadImage = (Button) (this.findViewById(R.id.btn_UploadImage));
        ImageView_Upload = (ImageView) (this.findViewById(R.id.ImageView_Upload));
        btn_UploadImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent oIntent = new Intent(Intent.ACTION_GET_CONTENT);
                oIntent.setType("image/*");
                startActivityForResult(oIntent,IMAGE_DISPLAY);
}
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // Check which request we're responding to
        if (requestCode == IMAGE_DISPLAY) {

            if (resultCode == RESULT_OK) {
                Uri oUri = data.getData();
                ImageView_Upload.setImageURI(oUri);
            }
        }
    }
}
