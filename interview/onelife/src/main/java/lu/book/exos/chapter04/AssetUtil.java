package lu.book.exos.chapter04;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;

public class AssetUtil {

    public static int totalAssetValues(final List<Asset> assetList){
        return totalTypedValues(assetList, Objects::nonNull);
    }

    public static int totalBondsValues(final List<Asset> assetList){
        return totalTypedValues(assetList, asset -> asset.getType().equals( Asset.AssetType.BOND));
    }

    public static int totalStockValues(final List<Asset> assetList){
        return totalTypedValues(assetList, asset -> asset.getType().equals( Asset.AssetType.STOCK));
    }

    private static int totalTypedValues(final List<Asset> assetList, Predicate<Asset> assetTypeFilter){
        return assetList.stream().filter(assetTypeFilter)
                .mapToInt(Asset::getValue).sum();
    }

    final List<Asset> assets = Arrays.asList(
            new Asset(Asset.AssetType.BOND, 1000),
            new Asset(Asset.AssetType.BOND, 2000),
            new Asset(Asset.AssetType.STOCK, 3000),
            new Asset(Asset.AssetType.STOCK, 4000)
    );

}
