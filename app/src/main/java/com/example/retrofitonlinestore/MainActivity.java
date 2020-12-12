package com.example.retrofitonlinestore;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Bundle;
import android.widget.TextView;

import com.example.retrofitonlinestore.api_interfaces.JsonPlaceHolderApi;
import com.example.retrofitonlinestore.models.Register;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        textViewResult=findViewById(R.id.textview);

        createPost();

    }

    void createPost(){
        Register reg = new Register("gurinder@gmail.com","sidhu");

        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl("http://10.0.0.28:3000/")

                .addConverterFactory(GsonConverterFactory.create())

                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<Register> call= jsonPlaceHolderApi.createPost(reg);

        call.enqueue(new Callback<Register>() {
            @Override
            public void onResponse(Call<Register> call, Response<Register> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code: "+ response.code());
                    return;
                }
                Register postResponse = response.body();

                String content="";
                //  content+="Code: "+ response.code()+"\n";
                content+="email: "+postResponse.getEmail()+"\n";
                content+="password: "+postResponse.getPassword()+"\n";

                textViewResult.append(content);

            }

            @Override
            public void onFailure(Call<Register> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });
    }
    public void getPosts(){
        Retrofit retrofit= new Retrofit.Builder()
                .baseUrl(" http:10.0.0.28:3000/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Register>> call=jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Register>>() {
            @Override
            public void onResponse(Call<List<Register>> call, Response<List<Register>> response) {
                if(!response.isSuccessful()){
                    textViewResult.setText("Code:"+response.code());
                    return;
                }
                List<Register> posts=response.body();
                for (Register post: posts){
                    String content="";

                    content += "email: " +post.getEmail() +"\n";
                    content += "password: " +post.getPassword() +"\n";

                    textViewResult.append(content);

                }
            }

            @Override
            public void onFailure(Call<List<Register>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });

    }
}