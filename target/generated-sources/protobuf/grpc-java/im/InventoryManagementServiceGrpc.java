package im;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.63.0)",
    comments = "Source: InventoryManagementService.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class InventoryManagementServiceGrpc {

  private InventoryManagementServiceGrpc() {}

  public static final java.lang.String SERVICE_NAME = "im.InventoryManagementService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest,
      im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> getAddStoreToInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "addStoreToInventory",
      requestType = im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest.class,
      responseType = im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest,
      im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> getAddStoreToInventoryMethod() {
    io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest, im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> getAddStoreToInventoryMethod;
    if ((getAddStoreToInventoryMethod = InventoryManagementServiceGrpc.getAddStoreToInventoryMethod) == null) {
      synchronized (InventoryManagementServiceGrpc.class) {
        if ((getAddStoreToInventoryMethod = InventoryManagementServiceGrpc.getAddStoreToInventoryMethod) == null) {
          InventoryManagementServiceGrpc.getAddStoreToInventoryMethod = getAddStoreToInventoryMethod =
              io.grpc.MethodDescriptor.<im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest, im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "addStoreToInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryManagementServiceMethodDescriptorSupplier("addStoreToInventory"))
              .build();
        }
      }
    }
    return getAddStoreToInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.UpdateInventoryRequest,
      im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> getUpdateInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "updateInventory",
      requestType = im.InventoryManagementServiceOuterClass.UpdateInventoryRequest.class,
      responseType = im.InventoryManagementServiceOuterClass.UpdateInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.UpdateInventoryRequest,
      im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> getUpdateInventoryMethod() {
    io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.UpdateInventoryRequest, im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> getUpdateInventoryMethod;
    if ((getUpdateInventoryMethod = InventoryManagementServiceGrpc.getUpdateInventoryMethod) == null) {
      synchronized (InventoryManagementServiceGrpc.class) {
        if ((getUpdateInventoryMethod = InventoryManagementServiceGrpc.getUpdateInventoryMethod) == null) {
          InventoryManagementServiceGrpc.getUpdateInventoryMethod = getUpdateInventoryMethod =
              io.grpc.MethodDescriptor.<im.InventoryManagementServiceOuterClass.UpdateInventoryRequest, im.InventoryManagementServiceOuterClass.UpdateInventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "updateInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.UpdateInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.UpdateInventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryManagementServiceMethodDescriptorSupplier("updateInventory"))
              .build();
        }
      }
    }
    return getUpdateInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.ViewInventoryRequest,
      im.InventoryManagementServiceOuterClass.ViewInventoryResponse> getViewInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "viewInventory",
      requestType = im.InventoryManagementServiceOuterClass.ViewInventoryRequest.class,
      responseType = im.InventoryManagementServiceOuterClass.ViewInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.ViewInventoryRequest,
      im.InventoryManagementServiceOuterClass.ViewInventoryResponse> getViewInventoryMethod() {
    io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.ViewInventoryRequest, im.InventoryManagementServiceOuterClass.ViewInventoryResponse> getViewInventoryMethod;
    if ((getViewInventoryMethod = InventoryManagementServiceGrpc.getViewInventoryMethod) == null) {
      synchronized (InventoryManagementServiceGrpc.class) {
        if ((getViewInventoryMethod = InventoryManagementServiceGrpc.getViewInventoryMethod) == null) {
          InventoryManagementServiceGrpc.getViewInventoryMethod = getViewInventoryMethod =
              io.grpc.MethodDescriptor.<im.InventoryManagementServiceOuterClass.ViewInventoryRequest, im.InventoryManagementServiceOuterClass.ViewInventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "viewInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.ViewInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.ViewInventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryManagementServiceMethodDescriptorSupplier("viewInventory"))
              .build();
        }
      }
    }
    return getViewInventoryMethod;
  }

  private static volatile io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.RestockInventoryRequest,
      im.InventoryManagementServiceOuterClass.RestockInventoryResponse> getRestockInventoryMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "restockInventory",
      requestType = im.InventoryManagementServiceOuterClass.RestockInventoryRequest.class,
      responseType = im.InventoryManagementServiceOuterClass.RestockInventoryResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.RestockInventoryRequest,
      im.InventoryManagementServiceOuterClass.RestockInventoryResponse> getRestockInventoryMethod() {
    io.grpc.MethodDescriptor<im.InventoryManagementServiceOuterClass.RestockInventoryRequest, im.InventoryManagementServiceOuterClass.RestockInventoryResponse> getRestockInventoryMethod;
    if ((getRestockInventoryMethod = InventoryManagementServiceGrpc.getRestockInventoryMethod) == null) {
      synchronized (InventoryManagementServiceGrpc.class) {
        if ((getRestockInventoryMethod = InventoryManagementServiceGrpc.getRestockInventoryMethod) == null) {
          InventoryManagementServiceGrpc.getRestockInventoryMethod = getRestockInventoryMethod =
              io.grpc.MethodDescriptor.<im.InventoryManagementServiceOuterClass.RestockInventoryRequest, im.InventoryManagementServiceOuterClass.RestockInventoryResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "restockInventory"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.RestockInventoryRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  im.InventoryManagementServiceOuterClass.RestockInventoryResponse.getDefaultInstance()))
              .setSchemaDescriptor(new InventoryManagementServiceMethodDescriptorSupplier("restockInventory"))
              .build();
        }
      }
    }
    return getRestockInventoryMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static InventoryManagementServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceStub>() {
        @java.lang.Override
        public InventoryManagementServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryManagementServiceStub(channel, callOptions);
        }
      };
    return InventoryManagementServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static InventoryManagementServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceBlockingStub>() {
        @java.lang.Override
        public InventoryManagementServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryManagementServiceBlockingStub(channel, callOptions);
        }
      };
    return InventoryManagementServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static InventoryManagementServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<InventoryManagementServiceFutureStub>() {
        @java.lang.Override
        public InventoryManagementServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new InventoryManagementServiceFutureStub(channel, callOptions);
        }
      };
    return InventoryManagementServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addStoreToInventory(im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddStoreToInventoryMethod(), responseObserver);
    }

    /**
     */
    default void updateInventory(im.InventoryManagementServiceOuterClass.UpdateInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateInventoryMethod(), responseObserver);
    }

    /**
     */
    default void viewInventory(im.InventoryManagementServiceOuterClass.ViewInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.ViewInventoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getViewInventoryMethod(), responseObserver);
    }

    /**
     */
    default void restockInventory(im.InventoryManagementServiceOuterClass.RestockInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.RestockInventoryResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getRestockInventoryMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service InventoryManagementService.
   */
  public static abstract class InventoryManagementServiceImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return InventoryManagementServiceGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service InventoryManagementService.
   */
  public static final class InventoryManagementServiceStub
      extends io.grpc.stub.AbstractAsyncStub<InventoryManagementServiceStub> {
    private InventoryManagementServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryManagementServiceStub(channel, callOptions);
    }

    /**
     */
    public void addStoreToInventory(im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddStoreToInventoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void updateInventory(im.InventoryManagementServiceOuterClass.UpdateInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getUpdateInventoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void viewInventory(im.InventoryManagementServiceOuterClass.ViewInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.ViewInventoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getViewInventoryMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void restockInventory(im.InventoryManagementServiceOuterClass.RestockInventoryRequest request,
        io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.RestockInventoryResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getRestockInventoryMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service InventoryManagementService.
   */
  public static final class InventoryManagementServiceBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<InventoryManagementServiceBlockingStub> {
    private InventoryManagementServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryManagementServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse addStoreToInventory(im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddStoreToInventoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public im.InventoryManagementServiceOuterClass.UpdateInventoryResponse updateInventory(im.InventoryManagementServiceOuterClass.UpdateInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getUpdateInventoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public im.InventoryManagementServiceOuterClass.ViewInventoryResponse viewInventory(im.InventoryManagementServiceOuterClass.ViewInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getViewInventoryMethod(), getCallOptions(), request);
    }

    /**
     */
    public im.InventoryManagementServiceOuterClass.RestockInventoryResponse restockInventory(im.InventoryManagementServiceOuterClass.RestockInventoryRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getRestockInventoryMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service InventoryManagementService.
   */
  public static final class InventoryManagementServiceFutureStub
      extends io.grpc.stub.AbstractFutureStub<InventoryManagementServiceFutureStub> {
    private InventoryManagementServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected InventoryManagementServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new InventoryManagementServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse> addStoreToInventory(
        im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddStoreToInventoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<im.InventoryManagementServiceOuterClass.UpdateInventoryResponse> updateInventory(
        im.InventoryManagementServiceOuterClass.UpdateInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getUpdateInventoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<im.InventoryManagementServiceOuterClass.ViewInventoryResponse> viewInventory(
        im.InventoryManagementServiceOuterClass.ViewInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getViewInventoryMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<im.InventoryManagementServiceOuterClass.RestockInventoryResponse> restockInventory(
        im.InventoryManagementServiceOuterClass.RestockInventoryRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getRestockInventoryMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_STORE_TO_INVENTORY = 0;
  private static final int METHODID_UPDATE_INVENTORY = 1;
  private static final int METHODID_VIEW_INVENTORY = 2;
  private static final int METHODID_RESTOCK_INVENTORY = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_STORE_TO_INVENTORY:
          serviceImpl.addStoreToInventory((im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest) request,
              (io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse>) responseObserver);
          break;
        case METHODID_UPDATE_INVENTORY:
          serviceImpl.updateInventory((im.InventoryManagementServiceOuterClass.UpdateInventoryRequest) request,
              (io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.UpdateInventoryResponse>) responseObserver);
          break;
        case METHODID_VIEW_INVENTORY:
          serviceImpl.viewInventory((im.InventoryManagementServiceOuterClass.ViewInventoryRequest) request,
              (io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.ViewInventoryResponse>) responseObserver);
          break;
        case METHODID_RESTOCK_INVENTORY:
          serviceImpl.restockInventory((im.InventoryManagementServiceOuterClass.RestockInventoryRequest) request,
              (io.grpc.stub.StreamObserver<im.InventoryManagementServiceOuterClass.RestockInventoryResponse>) responseObserver);
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

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddStoreToInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.InventoryManagementServiceOuterClass.AddStoreToInventoryRequest,
              im.InventoryManagementServiceOuterClass.AddStoreToInventoryResponse>(
                service, METHODID_ADD_STORE_TO_INVENTORY)))
        .addMethod(
          getUpdateInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.InventoryManagementServiceOuterClass.UpdateInventoryRequest,
              im.InventoryManagementServiceOuterClass.UpdateInventoryResponse>(
                service, METHODID_UPDATE_INVENTORY)))
        .addMethod(
          getViewInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.InventoryManagementServiceOuterClass.ViewInventoryRequest,
              im.InventoryManagementServiceOuterClass.ViewInventoryResponse>(
                service, METHODID_VIEW_INVENTORY)))
        .addMethod(
          getRestockInventoryMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              im.InventoryManagementServiceOuterClass.RestockInventoryRequest,
              im.InventoryManagementServiceOuterClass.RestockInventoryResponse>(
                service, METHODID_RESTOCK_INVENTORY)))
        .build();
  }

  private static abstract class InventoryManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    InventoryManagementServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return im.InventoryManagementServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("InventoryManagementService");
    }
  }

  private static final class InventoryManagementServiceFileDescriptorSupplier
      extends InventoryManagementServiceBaseDescriptorSupplier {
    InventoryManagementServiceFileDescriptorSupplier() {}
  }

  private static final class InventoryManagementServiceMethodDescriptorSupplier
      extends InventoryManagementServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    InventoryManagementServiceMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (InventoryManagementServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new InventoryManagementServiceFileDescriptorSupplier())
              .addMethod(getAddStoreToInventoryMethod())
              .addMethod(getUpdateInventoryMethod())
              .addMethod(getViewInventoryMethod())
              .addMethod(getRestockInventoryMethod())
              .build();
        }
      }
    }
    return result;
  }
}
