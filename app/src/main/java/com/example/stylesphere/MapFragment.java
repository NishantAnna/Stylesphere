package com.example.stylesphere;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

public class MapFragment extends Fragment {

    private SliderView sliderView;

    private int[] images = {R.drawable.beauty1, R.drawable.beauty2, R.drawable.beauty3};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_map, container, false);

        sliderView = rootView.findViewById(R.id.image_slider);
        SliderAdapter sliderAdapter = new SliderAdapter(images);
        sliderView.setSliderAdapter(sliderAdapter);

        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setScrollTimeInSec(3);
        sliderView.startAutoCycle();

        ImageView mumbaiImageView = rootView.findViewById(R.id.mumbai);
        mumbaiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), MumbaiSalon.class);
                startActivity(intent);
            }
        });
        ImageView bangaloreImageView = rootView.findViewById(R.id.banglore);
        bangaloreImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), BangaloreSalon.class);
                startActivity(intent);
            }
        });
        ImageView apImageView = rootView.findViewById(R.id.ap);
        apImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), APSalon.class);
                startActivity(intent);
            }
        });

        ImageView delhiImageView = rootView.findViewById(R.id.delhi);
        delhiImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), DelhiSalon.class);
                startActivity(intent);
            }
        });
        ImageView hydImageView = rootView.findViewById(R.id.hyd);
        hydImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), HydSalon.class);
                startActivity(intent);
            }
        });
        ImageView kolImageView = rootView.findViewById(R.id.kolkata);
        kolImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start MumbaiSalonActivity
                Intent intent = new Intent(getActivity(), KolkataSalon.class);
                startActivity(intent);
            }
        });

        return rootView;
    }
    private class SliderAdapter extends com.smarteist.autoimageslider.SliderViewAdapter<SliderAdapter.SliderAdapterVH> {

        private int[] images;

        public SliderAdapter(int[] images) {
            this.images = images;
        }

        @Override
        public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, parent, false);
            return new SliderAdapterVH(view);
        }

        @Override
        public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {
            viewHolder.imageView.setImageResource(images[position]);
        }

        @Override
        public int getCount() {
            return images.length;
        }

        class SliderAdapterVH extends com.smarteist.autoimageslider.SliderViewAdapter.ViewHolder {

            ImageView imageView;

            public SliderAdapterVH(View itemView) {
                super(itemView);
                imageView = itemView.findViewById(R.id.image_view);
            }
        }
    }
}
