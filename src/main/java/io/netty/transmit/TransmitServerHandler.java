package io.netty.transmit;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.CharsetUtil;

public class TransmitServerHandler extends ChannelInboundHandlerAdapter {

	@Override
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		Channel channel = ctx.channel();
		ByteBuf buf = Unpooled.copiedBuffer("Data from server to Client!", CharsetUtil.UTF_8);
		ChannelFuture channelFuture = channel.writeAndFlush(buf);
		channelFuture.addListener(new ChannelFutureListener() {

			public void operationComplete(ChannelFuture future) throws Exception {
				if(future.isSuccess()) {
					System.out.println("SUCCESS");
				}else {
					System.out.println("FAILED");
					future.cause().printStackTrace();
				}
			}
		});
		
	}
    @Override
    public void channelActive(ChannelHandlerContext ctx) {
    	System.out.println("**Is Active**");
    }
	@Override
	public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
		// TODO Auto-generated method stub
		cause.printStackTrace();
		ctx.close();
	}

}
