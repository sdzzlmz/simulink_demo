package io.netty.transmit;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;

public class TransmitClient{
	private static int port = 8888;
	private static String address = "127.0.0.1";
	public static void main(String[] args) throws Exception {
		EventLoopGroup workerGroup = new NioEventLoopGroup();
	    try {
	    	
	        Bootstrap b = new Bootstrap(); // (1)
	        b.group(workerGroup); // (2)
	        b.channel(NioSocketChannel.class); // (3)
	        b.option(ChannelOption.SO_KEEPALIVE, true); // (4)
	        b.handler(new ChannelInitializer<SocketChannel>() {
	            @Override
	            public void initChannel(SocketChannel ch) throws Exception {
	                ch.pipeline().addLast(new TransmitClientHandler());
	            }
	        });
	        
	        // Start the client.
	        ChannelFuture f;
				f = b.connect(address, port).sync();

	        // Wait until the connection is closed.
	        f.channel().closeFuture().sync();
	    } finally {
	        workerGroup.shutdownGracefully();
	    }
	}

}
