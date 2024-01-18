package pfeffer.oms.order.domain.dtos;

import java.util.Date;

public final class OrderDTO {

    /**
     * O ID do pedido para seu respectivo canal de vendas.
     */
    private String id;

    /**
     * O ID do canal de vendas no qual o pedido se originou.
     */
    private String channelId;

    /**
     * O ID da filial no qual o pedido está vinculado.
     */
    private String locationId;

    /**
     * A data na qual o pedido foi criado no OMS.
     */
    private Date createdAt;

    /**
     * A data referente a última atualização do pedido.
     */
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

}