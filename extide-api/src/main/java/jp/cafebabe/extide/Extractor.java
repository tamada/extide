package jp.cafebabe.extide;

import jp.cafebabe.extide.source.DataSource;

public interface Extractor {
    NameContainer extract(DataSource source);
}
