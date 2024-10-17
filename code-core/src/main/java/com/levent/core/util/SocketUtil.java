package com.levent.util;

import javax.net.ServerSocketFactory;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Random;

/**
 * @Author: guanxinyi
 * @CreateTime: 2024-10-09
 * @Description: 连接工具类
 * @Version: 1.0
 */
public class SocketUtil {

    /**
     * 判断端口是否可用
     * @param port
     * @return
     */
    public static boolean isPortAvailable(int port) {

        try {
            ServerSocket serverSocket = ServerSocketFactory.getDefault().createServerSocket(port,1);
            serverSocket.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private static Random random = new Random();

    /**
     * 端口占用时，获取一个随机端口
     * @param minPort
     * @param maxPort
     * @return
     */
    public static int findRandomPort(int minPort,int maxPort){
        int portRange = maxPort-minPort;
        return minPort+random.nextInt(portRange+1);
    }


    public static int findAvailableTcpPort(int minPort, int maxPort,int defaultPort){
        if(isPortAvailable(defaultPort)){
            return defaultPort;
        }
        if (maxPort <= minPort) {
            throw new IllegalArgumentException("maxPort should bigger than miPort!");
        }
        int portRange = maxPort-minPort;
        int searchCounter = 0;

        while(searchCounter<=portRange){
            // 随机获取一个端口，但这个端口可能相同
            int candidatePort = findRandomPort(minPort, maxPort);
            searchCounter++;
            if(isPortAvailable(candidatePort)){
                return candidatePort;
            }
        }
        throw new IllegalStateException(String.format("Could not find an available %s port in the range [%d, %d] after %d attempts", SocketUtil.class.getName(), minPort, maxPort, searchCounter));
    }
}
