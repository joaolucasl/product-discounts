package com.github.joaolucasl.chumlee;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.3.0)",
    comments = "Source: DiscountService.proto")
public final class DiscountServiceGrpc {

  private DiscountServiceGrpc() {}

  public static final String SERVICE_NAME = "com.github.joaolucasl.chumlee.DiscountService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest,
      com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse> METHOD_GET_DISCOUNT =
      io.grpc.MethodDescriptor.create(
          io.grpc.MethodDescriptor.MethodType.UNARY,
          generateFullMethodName(
              "com.github.joaolucasl.chumlee.DiscountService", "GetDiscount"),
          io.grpc.protobuf.ProtoUtils.marshaller(com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest.getDefaultInstance()),
          io.grpc.protobuf.ProtoUtils.marshaller(com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse.getDefaultInstance()));

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static DiscountServiceStub newStub(io.grpc.Channel channel) {
    return new DiscountServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static DiscountServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new DiscountServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary and streaming output calls on the service
   */
  public static DiscountServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new DiscountServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class DiscountServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getDiscount(com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest request,
        io.grpc.stub.StreamObserver<com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_GET_DISCOUNT, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_GET_DISCOUNT,
            asyncUnaryCall(
              new MethodHandlers<
                com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest,
                com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse>(
                  this, METHODID_GET_DISCOUNT)))
          .build();
    }
  }

  /**
   */
  public static final class DiscountServiceStub extends io.grpc.stub.AbstractStub<DiscountServiceStub> {
    private DiscountServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountServiceStub(channel, callOptions);
    }

    /**
     */
    public void getDiscount(com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest request,
        io.grpc.stub.StreamObserver<com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_GET_DISCOUNT, getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class DiscountServiceBlockingStub extends io.grpc.stub.AbstractStub<DiscountServiceBlockingStub> {
    private DiscountServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse getDiscount(com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest request) {
      return blockingUnaryCall(
          getChannel(), METHOD_GET_DISCOUNT, getCallOptions(), request);
    }
  }

  /**
   */
  public static final class DiscountServiceFutureStub extends io.grpc.stub.AbstractStub<DiscountServiceFutureStub> {
    private DiscountServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private DiscountServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected DiscountServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new DiscountServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse> getDiscount(
        com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_GET_DISCOUNT, getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_DISCOUNT = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final DiscountServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(DiscountServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_DISCOUNT:
          serviceImpl.getDiscount((com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountRequest) request,
              (io.grpc.stub.StreamObserver<com.github.joaolucasl.chumlee.DiscountServiceOuterClass.DiscountResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static final class DiscountServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.github.joaolucasl.chumlee.DiscountServiceOuterClass.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (DiscountServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new DiscountServiceDescriptorSupplier())
              .addMethod(METHOD_GET_DISCOUNT)
              .build();
        }
      }
    }
    return result;
  }
}
