.class public Lcom/huawei/hmf/tasks/CancellationTokenSource;
.super Ljava/lang/Object;


# instance fields
.field private impl:Lcom/huawei/hmf/tasks/a/c;


# direct methods
.method public constructor <init>()V
    .registers 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Lcom/huawei/hmf/tasks/a/c;

    invoke-direct {v0}, Lcom/huawei/hmf/tasks/a/c;-><init>()V

    iput-object v0, p0, Lcom/huawei/hmf/tasks/CancellationTokenSource;->impl:Lcom/huawei/hmf/tasks/a/c;

    return-void
.end method


# virtual methods
.method public cancel()V
    .registers 4

    iget-object v0, p0, Lcom/huawei/hmf/tasks/CancellationTokenSource;->impl:Lcom/huawei/hmf/tasks/a/c;

    iget-boolean v1, v0, Lcom/huawei/hmf/tasks/a/c;->c:Z

    if-nez v1, :cond_27

    iget-object v1, v0, Lcom/huawei/hmf/tasks/a/c;->b:Ljava/lang/Object;

    monitor-enter v1

    const/4 v2, 0x1

    :try_start_a
    iput-boolean v2, v0, Lcom/huawei/hmf/tasks/a/c;->c:Z

    iget-object v0, v0, Lcom/huawei/hmf/tasks/a/c;->a:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_12
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_22

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/Runnable;

    invoke-interface {v2}, Ljava/lang/Runnable;->run()V

    goto :goto_12

    :cond_22
    monitor-exit v1

    return-void

    :catchall_24
    move-exception v0

    monitor-exit v1
    :try_end_26
    .catchall {:try_start_a .. :try_end_26} :catchall_24

    throw v0

    :cond_27
    return-void
.end method

.method public getToken()Lcom/huawei/hmf/tasks/CancellationToken;
    .registers 2

    iget-object v0, p0, Lcom/huawei/hmf/tasks/CancellationTokenSource;->impl:Lcom/huawei/hmf/tasks/a/c;

    return-object v0
.end method
