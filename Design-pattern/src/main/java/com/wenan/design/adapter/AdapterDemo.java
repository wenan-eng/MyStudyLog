package com.wenan.design.adapter;

/*
音频播放器接口
 */
interface AudioPlayer {
    void playMp3();

    void PlayMp4();
}


/*
视频播放器接口
 */
interface VideoPlayer {
    void playVideo();
}

/*
adapter接口
 */
interface MediaAdapter {
    void playMedia(String mediaType);
}

/*
mp3播放器
 */
class Mp3Player implements AudioPlayer {

    @Override
    public void playMp3() {
        System.out.println("Mp3播放器，可以播放Mp3音乐");
    }

    @Override
    public void PlayMp4() {
        // 不实现功能
    }
}

/*
Mp4播放器
 */
class Mp4Player implements AudioPlayer {

    @Override
    public void playMp3() {
        // 不实现功能
    }

    @Override
    public void PlayMp4() {
        System.out.println("MP4播放器，可以播放MP4文件");
    }
}


/*
媒体适配器
 */
class MediaPlayer implements MediaAdapter {
    AudioPlayer audioPlayer;

    /**
     * 根据传入的媒体判断是mp3还是MP4
     * @param mediaType 媒体类型
     */
    @Override
    public void playMedia(String mediaType) {
        if ("mp4".equalsIgnoreCase(mediaType)) {
            audioPlayer = new Mp4Player();
            audioPlayer.PlayMp4();
        } else if ("mp3".equalsIgnoreCase(mediaType)) {
            audioPlayer = new Mp3Player();
            audioPlayer.playMp3();
        }
    }
}

/*
avi视频播放器,继承MediaAdapter类就可以实现播放Mp3和Mp4文件
 */
class AviPlayer extends MediaPlayer implements VideoPlayer {

    @Override
    public void playVideo() {
        System.out.println("avi播放器，播放Avi文件");
    }
}


/**
 * 具体实现调用
 */
public class AdapterDemo {
    public static void main(String[] args) {
        AviPlayer aviPlayer = new AviPlayer();

        // 播放avi文件
        aviPlayer.playVideo();
        // 播放mp4文件
        aviPlayer.playMedia("mp4");
        // 播放mp3文件
        aviPlayer.playMedia("mp3");
    }
}

