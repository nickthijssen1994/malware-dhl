.class public final Lcom/huawei/hmf/tasks/a/c;
.super Lcom/huawei/hmf/tasks/CancellationToken;


# instance fields
.field public final a:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation
.end field

.field public final b:Ljava/lang/Object;

.field public c:Z


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Lcom/huawei/hmf/tasks/CancellationToken;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/huawei/hmf/tasks/a/c;->a:Ljava/util/List;

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/huawei/hmf/tasks/a/c;->b:Ljava/lang/Object;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/huawei/hmf/tasks/a/c;->c:Z

    return-void
.end method


# virtual methods
.method public final isCancellationRequested()Z
    .registers 2

    iget-boolean v0, p0, Lcom/huawei/hmf/tasks/a/c;->c:Z

    return v0
.end method

.method public final register(Ljava/lang/Runnable;)Lcom/huawei/hmf/tasks/CancellationToken;
    .registers 4

    iget-object v0, p0, Lcom/huawei/hmf/tasks/a/c;->b:Ljava/lang/Object;

    monitor-enter v0

    :try_start_3
    iget-boolean v1, p0, Lcom/huawei/hmf/tasks/a/c;->c:Z

    if-eqz v1, :cond_b

    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    goto :goto_10

    :cond_b
    iget-object v1, p0, Lcom/huawei/hmf/tasks/a/c;->a:Ljava/util/List;

    invoke-interface {v1, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_10
    monitor-exit v0

    return-object p0

    :catchall_12
    move-exception p1

    monitor-exit v0
    :try_end_14
    .catchall {:try_start_3 .. :try_end_14} :catchall_12

    throw p1
.end method
