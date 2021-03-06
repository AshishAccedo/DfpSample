package com.dfpplayer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.brightcove.player.edge.Catalog;
import com.brightcove.player.edge.VideoListener;
import com.brightcove.player.model.Video;
import com.brightcove.player.view.BrightcovePlayerFragment;
import com.brightcove.player.view.BrightcoveVideoView;
import com.dfpplayer.ima.ImaManager;

import java.util.HashMap;
import java.util.Map;


/**
 * Created by ashish (Min2) on 05/03/17.
 */

public class DfpPlayerFragment extends BrightcovePlayerFragment {

    public static final String TAG = DfpPlayerFragment.class.getSimpleName();

    private Map<String, String> options = new HashMap<String, String>();

//    private String adRulesUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=640x360&iu=/6062/iab_vast_samples/skippable&ciu_szs=300x250,728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=[referrer_url]&correlator=[timestamp]";

//    private String adRulesUrl = "http://pubads.g.doubleclick.net/gampad/ads?sz=640x480&iu=%2F15018773%2Feverything2&ciu_szs=300x250%2C468x60%2C728x90&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&url=dummy&correlator=[timestamp]&cmsid=133&vid=10XWSh7W4so&ad_rule=1";

    /**
     * Provide a sample illustrative ad.
     */
    private String[] googleAds = {
            // Honda Pilot
//            ""
            "https://pubads.g.doubleclick.net/gampad/ads?sz=640x480|1x1&iu=/423477888/SonyLiv/SonyLiv_Pre-Roll_Android&ciu_szs=1x1&ad_rule=1&impl=s&gdfp_req=1&env=vp&output=vmap&unviewed_position_start=1&url=%25%25REFERRER_URL_UNESC%25%25&%25%DESCRIPTION_URL_UNESC%25%25&correlator=%25%CACHEBUSTER%25%25"
//            "http://pubads.g.doubleclick.net/gampad/ads?sz=400x300&iu=%2F6062%2Fhanna_MA_group%2Fvideo_comp_app&ciu_szs=&impl=s&gdfp_req=1&env=vp&output=xml_vast2&unviewed_position_start=1&m_ast=vast&url=[referrer_url]&correlator=[timestamp]"
    };

    public static DfpPlayerFragment newInstance() {
        DfpPlayerFragment fragment = new DfpPlayerFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frag_dfp_player, container, false);
        brightcoveVideoView = (BrightcoveVideoView) view.findViewById(R.id.brightcove_video_view);
        brightcoveVideoView.setClosedCaptioningEnabled(false);

        super.onCreateView(inflater, container, savedInstanceState);


        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        brightcoveVideoView = (BrightcoveVideoView) view.findViewById(R.id.brightcove_video_view);

        setupPlayer();

        super.onViewCreated(view, savedInstanceState);
    }

    private void setupPlayer() {


//        final Video video = createVideoFromUrl(videoUrl);

//        Catalog catalog = new Catalog("ErQk9zUeDVLIp8Dc7aiHKq8hDMgkv5BFU7WGshTc-hpziB3BuYh28A..");



        Video video = createVideoFromUrl("https://sonyhdslive-lh.akamaihd.net/i/LIVELINEARCHANNELWAHSD_2@324771/index_100_av-p.m3u8?sd=10&rebase=on&id=AgC2SfL6YBG2JpMHMVl8BkTC0SpVbBy%2frYkaeUHMRu8inYQ3DHLx4I+pRLNhOPyxeLBTSrs2hL4lZw%3d%3d&hdntl=exp=1496471827~acl=%2fi%2f*~data=hdntl~hmac=808df26a60cb28eff4d28a242510d2dba361d9d8658f1e3bbe3090f85e633632");
        brightcoveVideoView.add(video);
        brightcoveVideoView.start();
//        ImaManager.setupIma(brightcoveVideoView, googleAds);

    }

    private Video createVideoFromUrl(final String videoUrl) {
        return Video.createVideo(videoUrl);
    }

}
