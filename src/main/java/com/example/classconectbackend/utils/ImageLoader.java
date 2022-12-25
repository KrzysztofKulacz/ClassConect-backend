package com.example.classconectbackend.utils;

import com.example.classconectbackend.team.Subject;

import java.util.List;
import java.util.Random;

public class ImageLoader {

    public static String loadSubject(Subject subject) {
        switch (subject) {
            case PHYSICS:
                var physicsImageUrl = List.of(
                        "https://images.unsplash.com/photo-1451187580459-43490279c0fa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1172&q=80",
                        "https://images.unsplash.com/photo-1462331940025-496dfbfc7564?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=911&q=80",
                        "https://images.unsplash.com/photo-1636466497217-26a8cbeaf0aa?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8UEhZU0lDU3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1576319155264-99536e0be1ee?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NHx8UEhZU0lDU3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1429552077091-836152271555?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NXx8cG93ZXJ8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(physicsImageUrl);
            case MATH:
                var mathImageUrl = List.of(
                        "https://images.unsplash.com/photo-1635070041078-e363dbe005cb?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8M3x8TWF0aHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1518133910546-b6c2fb7d79e3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8TWF0aHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1509228468518-180dd4864904?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjB8fE1hdGh8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://media.istockphoto.com/id/1446696257/photo/colorful-wooden-abacus-for-childrens-learning.jpg?b=1&s=170667a&w=0&k=20&c=Whc4hlxKs3_cUyurNfym7DDWL3bxFxZx5rOoUVoRZzs=",
                        "https://images.unsplash.com/photo-1596495577886-d920f1fb7238?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8&auto=format&fit=crop&w=1174&q=80",
                        "https://media.istockphoto.com/id/181133824/photo/sine-wave-and-consine-nathematics-sine-and-cosine-graphic.jpg?b=1&s=170667a&w=0&k=20&c=KLH3RUVzg9gexYqFlaktOe1eRtNkCWTCVIpAsMFEsFI="
                        );
                return getRandomImage(mathImageUrl);
            case PROGRAMING:
                var programingImageUrl = List.of(
                        "https://images.unsplash.com/photo-1592609931095-54a2168ae893?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mjl8fGNvZGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1627398242454-45a1465c2479?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzh8fGNvZGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1550439062-609e1531270e?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTZ8fGNvZGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1623479322729-28b25c16b011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NTB8fGNvZGV8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1535551951406-a19828b0a76b?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MXx8aGVsbG8lMjB3b3JsZHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(programingImageUrl);
            case ALGORITHMS_AND_DATA_STRUCTURES:
                var algorithmImageUrl = List.of(
                        "https://images.unsplash.com/photo-1642952469120-eed4b65104be?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8YWxnb3JpdGhtfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1545987796-200677ee1011?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTV8fGRhdGF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1644325349124-d1756b79dd42?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjR8fGRhdGF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1639322537228-f710d846310a?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NzB8fGRhdGF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1639762681485-074b7f938ba0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nzd8fGRhdGF8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(algorithmImageUrl);
            case NETWORK_SECURITY:
                var networkImageUrl = List.of(
                        "https://images.unsplash.com/photo-1544197150-b99a580bb7a8?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Nnx8bmV0d29ya3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1520869562399-e772f042f422?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8OXx8bmV0d29ya3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1558494949-ef010cbdcc31?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTd8fG5ldHdvcmt8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1591808216268-ce0b82787efe?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjN8fG5ldHdvcmt8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/flagged/photo-1579274216947-86eaa4b00475?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8NjV8fG5ldHdvcmt8ZW58MHx8MHx8&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(networkImageUrl);
            case MACHINE_LEARNING:
                var machineLearningUrl = List.of(
                        "https://images.unsplash.com/photo-1550432163-9cb326104944?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MjZ8fG1hY2hpbmUlMjBsZWFybmluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1516192518150-0d8fee5425e3?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MzN8fG1hY2hpbmUlMjBsZWFybmluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1526378722484-bd91ca387e72?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mzl8fGFydGlmaWNhbCUyMGludGVsaWdlbmNlfGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1604667070723-a2da9cd743d0?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8ODR8fHJvYm90fGVufDB8fDB8fA%3D%3D&auto=format&fit=crop&w=500&q=60",
                        "https://images.unsplash.com/photo-1591453089816-0fbb971b454c?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8MTB8fG1hY2hpbmUlMjBsZWFybmluZ3xlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60"
                );
                return getRandomImage(machineLearningUrl);
            default:
                return "https://images.unsplash.com/photo-1627334901021-b7378029fd05?ixlib=rb-4.0.3&ixid=MnwxMjA3fDB8MHxzZWFyY2h8Mnx8YmFjbGdyb3VuZHxlbnwwfHwwfHw%3D&auto=format&fit=crop&w=500&q=60";
        }
    }

    private static String getRandomImage(List<String> imagesUrls) {
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
