package pfeffer.oms.inventory.services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pfeffer.oms.inventory.domain.dtos.ChannelStockDTO;
import pfeffer.oms.inventory.domain.exceptions.StockException;
import pfeffer.oms.inventory.domain.mappers.ChannelStockMapper;
import pfeffer.oms.inventory.domain.usecases.channel.CreateChannelStock;
import pfeffer.oms.inventory.domain.usecases.channel.IChannelStockRepository;
import pfeffer.oms.inventory.domain.usecases.channel.UpdateChannelStock;
import pfeffer.oms.inventory.infra.jakarta.mappers.JakartaChannelStockMapper;
import pfeffer.oms.inventory.infra.jakarta.repository.JakartaChannelStockRepository;

import java.util.List;

@Service
public class ChannelStockService implements IChannelStockRepository {

    private final JakartaChannelStockRepository repository;

    @Autowired
    public ChannelStockService(JakartaChannelStockRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public ChannelStockDTO createChannelStock(ChannelStockDTO dto) {
        CreateChannelStock createChannelStock = new CreateChannelStock(repository);

        return createChannelStock.execute(dto);
    }

    @Transactional
    public ChannelStockDTO updateChannelStock(String channelId, ChannelStockDTO dto) {
        UpdateChannelStock updateChannelStock = new UpdateChannelStock(repository);

        return updateChannelStock.execute(channelId, dto);
    }

    public List<ChannelStockDTO> listChannelStockTypes() {
        return this.repository.findAll().stream().map(jakartaChannelStock ->
                ChannelStockMapper.toDTO(JakartaChannelStockMapper.toDomain(jakartaChannelStock))
        ).toList();
    }

    @Override
    public List<ChannelStockDTO> findChannelStockTypesByChannelId(String channelId) {
        List<ChannelStockDTO> stockTypes = this.repository.findChannelStockTypesByChannelId(channelId);

        if (stockTypes.isEmpty()) {
            throw new StockException("There is not a single stock type associated with for the provided channel", 400);
        }

        return stockTypes;
    }

}