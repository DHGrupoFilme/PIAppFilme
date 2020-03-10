package com.example.myapplication.view;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;
import com.example.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class InstrucoesFragment extends Fragment {

    private VideoView simpleVideoViewQuiz;
    private VideoView simpleVideoViewTrunfo;
    private MediaController mediaControlsQuiz;
    private MediaController mediaControlsTrunfo;
    private Button bntPular;

    public InstrucoesFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_instrucoes, container, false);
        initViews(view);
        startTutorial();
        bntPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                proximaActivity();
            }
        });
        return view;
    }

    private void proximaActivity() {
        Intent intent = new Intent(getActivity(), FiltroActivity.class);
        startActivity(intent);
    }

    private void startTutorial() {
        if (mediaControlsQuiz == null || mediaControlsTrunfo == null) {
            mediaControlsQuiz = new MediaController(getContext());
            mediaControlsQuiz.setAnchorView(simpleVideoViewQuiz);
            mediaControlsTrunfo = new MediaController(getContext());
            mediaControlsTrunfo.setAnchorView(simpleVideoViewTrunfo);
        }

        simpleVideoViewQuiz.setMediaController(mediaControlsQuiz);
        simpleVideoViewQuiz.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.videoexemplo));
        simpleVideoViewQuiz.start();
        simpleVideoViewTrunfo.setMediaController(mediaControlsTrunfo);
        simpleVideoViewTrunfo.setVideoURI(Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.videoexemplo));
    }

    private void initViews(View view) {
        simpleVideoViewQuiz = view.findViewById(R.id.videoViewQuiz);
        simpleVideoViewTrunfo = view.findViewById(R.id.videoViewTrunfo);
        bntPular = view.findViewById(R.id.buttonPular);
    }
}
