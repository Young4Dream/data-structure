package com.yan.uf;

import com.yan.util.StopWatchProxy;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Random;

/**
 * @author Administrator
 * @since 1.0.0
 * 2019/11/16 09:45
 */
@RunWith(JUnit4.class)
public class UFTest {
    private UFDS ufds1;
    private UFDS ufds2;
    private UFDS ufds3;
    private UFDS ufds4;
    private UFDS ufds5;
    private UFDS ufds6;

    @Before
    public void before() {
        int low_size = 100000;
        int high_size = 1000000;
        ufds1 = new UFDS01(low_size);
        ufds2 = new UFDS02(low_size);
        ufds3 = new UFDS03(low_size);
        ufds4 = new UFDS04(high_size);
        ufds5 = new UFDS05(high_size);
        ufds6 = new UFDS06(high_size);
    }

    @Test
    public void test() {
        StopWatchProxy<Union> stopWatchProxy = new StopWatchProxy<>(ufds -> {
            Random random = new Random();
            int size = ufds.size();
            for (int i = 0; i < size; i++) {
                ufds.union(random.nextInt(size), random.nextInt(size));
            }
        });
        stopWatchProxy.get().test_union(ufds1);
        stopWatchProxy.get().test_union(ufds2);
        stopWatchProxy.get().test_union(ufds3);
        stopWatchProxy.get().test_union(ufds4);
        stopWatchProxy.get().test_union(ufds5);
        stopWatchProxy.get().test_union(ufds6);
    }

    @After
    public void after() {

    }

    public interface Union {
        void test_union(UFDS ufds);
    }

}