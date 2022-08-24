.class public final Lcom/huawei/hmf/tasks/a/a;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/huawei/hmf/tasks/a/a$a;
    }
.end annotation


# static fields
.field static final a:I

.field static final b:I

.field private static final c:Lcom/huawei/hmf/tasks/a/a;

.field private static final e:I


# instance fields
.field private final d:Ljava/util/concurrent/Executor;


# direct methods
.method static constructor <clinit>()V
    .registers 1

    new-instance v0, Lcom/huawei/hmf/tasks/a/a;

    invoke-direct {v0}, Lcom/huawei/hmf/tasks/a/a;-><init>()V

    sput-object v0, Lcom/huawei/hmf/tasks/a/a;->c:Lcom/huawei/hmf/tasks/a/a;

    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Runtime;->availableProcessors()I

    move-result v0

    sput v0, Lcom/huawei/hmf/tasks/a/a;->e:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/huawei/hmf/tasks/a/a;->a:I

    sget v0, Lcom/huawei/hmf/tasks/a/a;->e:I

    mul-int/lit8 v0, v0, 0x2

    add-int/lit8 v0, v0, 0x1

    sput v0, Lcom/huawei/hmf/tasks/a/a;->b:I

    return-void
.end method

.method public constructor <init>()V
    .registers 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/huawei/hmf/tasks/a/a$a;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Lcom/huawei/hmf/tasks/a/a$a;-><init>(B)V

    iput-object v0, p0, Lcom/huawei/hmf/tasks/a/a;->d:Ljava/util/concurrent/Executor;

    return-void
.end method

.method public static a()Ljava/util/concurrent/ExecutorService;
    .registers 8

    new-instance v7, Ljava/util/concurrent/ThreadPoolExecutor;

    sget v1, Lcom/huawei/hmf/tasks/a/a;->a:I

    sget v2, Lcom/huawei/hmf/tasks/a/a;->b:I

    sget-object v5, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    new-instance v6, Ljava/util/concurrent/LinkedBlockingQueue;

    invoke-direct {v6}, Ljava/util/concurrent/LinkedBlockingQueue;-><init>()V

    const-wide/16 v3, 0x1

    move-object v0, v7

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    const/4 v0, 0x1

    invoke-virtual {v7, v0}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    return-object v7
.end method

.method public static b()Ljava/util/concurrent/Executor;
    .registers 1

    sget-object v0, Lcom/huawei/hmf/tasks/a/a;->c:Lcom/huawei/hmf/tasks/a/a;

    iget-object v0, v0, Lcom/huawei/hmf/tasks/a/a;->d:Ljava/util/concurrent/Executor;

    return-object v0
.end method
