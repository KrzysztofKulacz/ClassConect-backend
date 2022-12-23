package com.example.classconectbackend.utils;

import com.example.classconectbackend.team.Subject;

import java.util.List;
import java.util.Random;

public class ImageLoader {

    public static String loadSubject(Subject subject){
        switch (subject){
            case PHYSICS:
                var physicsImageUrl = List.of(
                        "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80",
                        "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=911&q=80",
                        "https://images.unsplash.com/photo-1636466497217-26a8cbeaf0aa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8UEhZU0lDU3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1576319155264-99536e0be1ee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8UEhZU0lDU3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1429552077091-836152271555?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cG93ZXJ8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(physicsImageUrl);
            default:
                return "test";
        }
    }

    private static String getRandomImage(List<String> imagesUrls){
        var random = new Random();
        return imagesUrls.get(random.nextInt(imagesUrls.size()));
    }
}
//List.of(
//                        "",
//                        "",
//                        "",
//                        "",
//                        ""
//                );
